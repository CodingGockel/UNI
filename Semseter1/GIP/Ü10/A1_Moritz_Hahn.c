#include <stdio.h>

int linearSearch(int searchNum, int arr[], int arrLen) {
    for (int i = 0; i < arrLen; i++) {
        if (arr[i] == searchNum) {
            return i;
        }
    }
    return -1;
}

int binarySearch(int searchNum, int arr[], int arrLen) {
    int left = 0;
    int right = arrLen - 1;
    while (left <= right) {
        int middle = (left + right) / 2;
        if (arr[middle] == searchNum) {
            return middle;
        } else if (arr[middle] < searchNum) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
    return -1;
}

int binarySearchZeigerArythmetik(int searchNum, int* arr, int arrLen) {
    int* left = arr;
    int* right = arr + arrLen - 1;
    while (left <= right) {
        int* middle = left + (right - left) / 2;
        if (*middle == searchNum) {
            return middle - arr;
        } else if (*middle < searchNum) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
    return -1;
}


int main() {
    int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    int searchNum, position;

    printf("Enter a number to search for: ");
    scanf("%d", &searchNum);

    position = linearSearch(searchNum, primes, sizeof(primes)/sizeof(primes[0]));
    if (position != -1) {
        printf("Number found at position %d using linear search\n", position);
    } else {
        printf("Number not found using linear search\n");
    }

    position = binarySearch(searchNum, primes, sizeof(primes)/sizeof(primes[0]));
    if (position != -1) {
        printf("Number found at position %d using binary search\n", position);
    } else {
        printf("Number not found using binary search\n");
    }

    return 0;
}

