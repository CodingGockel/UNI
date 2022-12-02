#include <stdio.h>

int getSum(int n){
    int sum=0;
    while(n>9){
        int z=(n%10)*(n%10);
        sum=sum+z;
        n/=10;
    }
    sum+=n*n;
    return sum;
}

int isHappy(int n){
    int sum=n;
    while(1){
        if(n==1){
            return 1;
        }else if(n==20){
            return 0;
        }else{
            n=getSum(n);
        }
    }
}

int main(){
    for (int i=1; i<=500;i++){
        int k= isHappy(i);
        if(k==1){
            printf("%d: is Happy\n",i);
        }
    }
}
