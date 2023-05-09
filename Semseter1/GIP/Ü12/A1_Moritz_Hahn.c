#include <stdbool.h>
#include <string.h>
#include <stdio.h>
int fib(n){
    if(n==1||n==0){
        return 1;
    }
    return fib(n-1)+fib(n-2);
}
int countDigit(int n, int digit) {
    if (n == 0) {
        return 0;
    } else {
        if (n % 10 == digit) {
            return 1 + countDigit(n/10, digit);
        } else {
            return countDigit(n/10, digit);
        }
    }
}
int isSortedDescending(int n) {
    if (n / 10 == 0) {
        return 1;
    } else {
        int lastDigit = n % 10;
        int remainingDigits = n / 10;
        int nextDigit = remainingDigits % 10;
        if (lastDigit > nextDigit) {
            return 0;
        } else {
            return isSortedDescending(remainingDigits);
        }
    }
}
int main() {
    int n,k,digit,z;
    printf("Enter a positive integer: \n");
    scanf("%d", &n);
    printf("The %dth Fibonacci number is: %d\n", n, fib(n));
    printf("Enter a positive integer (not longer than 10 digits): ");
    scanf("%d", &k);
    printf(" Enter a digit: ");
    scanf("%d", &digit);
    printf("The number of occurrences of %d in %d is: %d\n", digit, k, countDigit(k, digit));
     printf("\n Enter a positive integer: ");
    scanf("%d", &z);
    if (isSortedDescending(z)) {
        printf("The digits of %d are sorted in descending order.\n", z);
    } else {
        printf("The digits of %d are not sorted in descending order.\n", z);
    }
    return 0;
}


