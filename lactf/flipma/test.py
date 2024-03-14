for i in range(8):
        for j in range(8):
            if (old >> (i*8+j)) & 1 != (new >> (i*8+j)) & 1:
                flip(a+i, j)