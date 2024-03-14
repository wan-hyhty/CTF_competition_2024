from pwn import *
from MorseCodePy import decode

r = remote("207.148.79.171", 4000)
cnt = 0
for i in range(100):
    # cnt+=1
    print(cnt)
    print(r.recvuntil(b'Question: \n'))
    res = decode(r.recvuntil(b' \n', drop=True).decode(),language='english').upper()
    res = str(res).replace('\\', '/')        
    print(res)
    r.sendafter(b'Answer: \n',str(res))
    

r. interactive()
