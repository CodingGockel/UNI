#include <stdbool.h>
#include <string.h>
#include <stdio.h>
bool is_valid_letter(char c) {
    char valid_letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    for (int i = 0; i < 8; i++) {
        if (c == valid_letters[i]) {
            return true;
        }
    }
    return false;
}

bool is_valid_number(char c) {
    char valid_numbers[] = {'1', '2', '3', '4', '5', '6', '7', '8'};
    for (int i = 0; i < 8; i++) {
        if (c == valid_numbers[i]) {
            return true;
        }
    }
    return false;
}

bool is_valid_field(char* s) {
    return is_valid_letter(s[0]) && is_valid_number(s[1]);
}

int main() {
    char field[3];
    while (true) {
        printf("Enter a chess board field notation (e.g. e5): ");
        scanf("%s", field);
        if (strlen(field) != 2) {
            printf("Invalid input: field notation must be 2 characters long.\n");
        } else if (is_valid_field(field)) {
            printf("Valid input.\n");
        } else {
            printf("Invalid input: invalid field notation.\n");
        }
    }
    return 0;
}


