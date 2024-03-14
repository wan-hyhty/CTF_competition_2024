s1 = '35T74'
s2 = 'h1AorC'
s3 = '0XhYc'
res = ''
for x in range(0, 15):
    for i in range(0, len(s1), 2):
        for y in range(0, 255):
            if chr(y) == s1[i]:
                print(chr(y))
                print(len(s1) - i/2 -1)