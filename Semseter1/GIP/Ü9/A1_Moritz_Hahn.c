
int decimalToBinary(int n);
int binaryToDecimal(int n);
#include <stdio.h>
#include <math.h>
#include <stdio.h>

int main(void){
    int bin,dec;
    printf("bitte gib eine Dezimalzahl ein!:\n");
    scanf("%d",&dec);
    fflush(stdin);
    printf("bitte gib eine Binärzahl ein!:\n");
    scanf("%d",&bin);
    fflush(stdin);
    printf("deine Dezimalzahl ist: %d in binär\ndeine Binärzahl ist: %d in dezimal\n",decimalToBinary(dec),binaryToDecimal(bin));

}

int binaryToDecimal(int n){
    int ret=0; int i=0;
    while(n>0){
        ret+=n%10*pow(2,i);
        n/=10;
        i++;
    }
    return ret;
}

int decimalToBinary(int n){ 
    int m=1;
    int ret=0;
    while(n>0){
        ret+=(n%2)*m;
        m*=10;
        n=n/2;
    }
    return ret;
}  
