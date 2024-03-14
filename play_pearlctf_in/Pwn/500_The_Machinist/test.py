v13 = 0x85  # Giá trị ban đầu của v13
v13 &= ~(1 << 0)  
# v13 |= 1 << 1

print("Giá trị của v13 sau khi tính toán: ", bin(v13))