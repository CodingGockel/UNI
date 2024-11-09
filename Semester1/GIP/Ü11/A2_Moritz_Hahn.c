#include <stdio.h>
#include <stdlib.h>
int stringLen(char *str) {
    int len = 0;
    while (*str++) {
        len++;
    }
    return len;
}
int stringCount(char c, char *str) {
    int count = 0;
    while (*str) {
        if (*str++ == c) {
            count++;
        }
    }
    return count;
}
char* stringCat(char *str1, char *str2) {
    int len1 = stringLen(str1);
    int len2 = stringLen(str2);
    char *result = (char*) malloc(len1 + len2 + 1);
    char *p = result;
    while (*str1) {
        *p++ = *str1++;
    }
    while (*str2) {
        *p++ = *str2++;
    }
    *p = '\0';
    return result;
}

int main() {
    char str1[100], str2[100], c;
    printf("Enter first string: ");
    scanf("%s", str1);
    printf("Enter second string: ");
    scanf("%s", str2);
    printf("The length of the first string is: %d\n", stringLen(str1));
    printf("Enter a character to count its occurrences in the first string: ");
    scanf(" %c", &c);
    printf("The character %c appears %d times in the first string.\n", c, stringCount(c, str1));
    char* concatenated = stringCat(str1, str2);
    printf("The concatenated string is: %s\n", concatenated);
    free(concatenated);
    return 0;
}


