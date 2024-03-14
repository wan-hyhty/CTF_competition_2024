#include <stdio.h>
#include <string.h>
char a35t74[] = "35T74";
char aH1aorc[] = "h1AorC";
char a0xhyc[] = "0XhYc";
int main()
{
    char a1[] = "ch0Co14T3";
    for (int i = 0; i < strlen("35T74"); i += 2)
        a1[strlen(a1) - i / 2 - 1] = a35t74[i];
    for (int j = 1; j < strlen("h1AorC"); j += 2)

        a1[strlen(a1) - j / 2 - 4] = aH1aorc[j];

    for (int k = 0; k < strlen("0XhYc"); k += 2)
        a1[strlen(a1) - k / 2 - 7] = a0xhyc[k];
    printf(a1);
}