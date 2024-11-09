#include <stdio.h>

int isPrim(int n){
    for(int i=2;i<=n/2;i++){
        if(n%i==0){
            return 0;
        }
    }
    return 1;
}

int main(){
    int n; 
    printf("Bitte gebe deine Zahl ein:\n");
    scanf("%d",&n);
    while(n>1){
        for(int i=n;i>=2;i--){
            if((isPrim(i)==1)&&(n%i==0)){
                printf("%d\n",i);
                n=n/i;
                break;
            }
        }
    }
}