#!/usr/bin/python3

from pwn import *
from ctypes import *
exe = ELF('mammam', checksec=False)
libc = CDLL('/usr/lib/x86_64-linux-gnu/libc.so.6',)
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
        p = remote('207.148.79.171', 2500)
else:
        p = process(exe.path)

GDB()
res = ""
for i in range(100):
        libc.srand(i)
        res += str(libc.rand()%3+1) + ' '
        
sla(b'sau:', res) 
# print(res)
p.interactive()
