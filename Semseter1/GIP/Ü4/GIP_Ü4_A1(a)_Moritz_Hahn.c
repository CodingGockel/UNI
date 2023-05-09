#include <stdio.h>

int main(){
    int x = 49; 
    if(!(x >= 0 && x < 50 || x > 50 && x <= 100)){
        printf("1: true\n");
    }else{
        printf("1: false\n");
    }
    if(x++ == 49 || x-- == 49){
        printf("2: true\n");
    }else{
        printf("2: false\n");
    }
    if(!(x >= 0 && x < 50 || x > 50 && x <= 100)){
        printf("3: true\n");
    }else{
        printf("3: false\n");
    }
    int k; 
    scanf("%d", &k); 
    if(!(k > 0 && k%10 <= 7) == (!(k > 0) || !(k%10 <= 7))){
        printf("4: true\n");
    }else{
        printf("4: false\n");
    }
    return 0;
}