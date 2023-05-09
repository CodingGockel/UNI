#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main(){
    int x,oldX=0;
    int current=1;
    int max=1;
    do{
        printf("Gebe deine Zahl ein:\n");
        scanf("%d",&x);
        if(x==oldX){
            current++;
            if(current>max){
                max=current;
            }
        }else{
            current=1;
        }
        oldX=x;
    }while(x>0);
    printf("Anzahl aufeinander folgender Zahlen: %d\n",max);
    return 0;
}