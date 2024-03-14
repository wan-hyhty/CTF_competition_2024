#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>

int main() {
    // Tạo một vùng nhớ 4KB (1 trang) và gắn cờ đọc-viết
    void* buffer = mmap(NULL, 0x10000, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);
    if (buffer == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Thay đổi cờ gắn liền của trang này thành chỉ đọc
    if (mprotect(buffer+0x100, 0x500, PROT_EXEC|PROT_WRITE ) == -1) {
        perror("mprotect");
        exit(EXIT_FAILURE);
    }

    // Thử ghi vào trang, sẽ gây ra lỗi SIGSEGV (segmentation fault)
    *(int*)buffer = 42;

    // Giải phóng vùng nhớ
    if (munmap(buffer, 0x1000) == -1) {
        perror("munmap");
        exit(EXIT_FAILURE);
    }

    return 0;
}
