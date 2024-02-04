#!/usr/bin/python3

from pwn import *



# rop.write(7, 8, 9)
# find_gadget(['pop rdi, ret'])
info = lambda msg: log.info(msg)
sla = lambda msg, data: p.sendlineafter(msg, data)
sa = lambda msg, data: p.sendafter(msg, data)
sl = lambda data: p.sendline(data)
s = lambda data: p.send(data)



p = remote('35.225.17.48', 6318)
sa(b'WRT54GV81', "Broadcom" + "\n\0")
print(p.recvuntil(b'again.'))
p.interactive()
