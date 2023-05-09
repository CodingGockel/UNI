#include <stdio.h>

int prost_rekursiv(int n){
    if(n==2){
        return 1;
    }
    return n-1 + prost_rekursiv(n-1);
}

int prost_iterativ(int n){
    int sum=0;
    if(n<2){
        return 0;
    }
    while(n>=2){
        sum += n-1;
        n--;
    }
    return sum;
}

int main(){
    printf("%d",prost_iterativ(4));
}