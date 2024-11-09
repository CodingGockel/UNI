#include <stdio.h>

int isISB(char* str){
    int sum=0;
    int i=10;
    char* start= str;
    while(*str&&i>=2){
        if(*str!='-'){
            sum += (*str-48)*i;
            i--;
        }
        *str++;
    }
    int R=sum%11;
    char pruef;
    if(R==1){
        pruef= 'X';
    }else{
        pruef= 11-(sum%11) +48;
    }
    printf("R: %d pruef:%c str[12]: %c\n",R,pruef,start[12]);
    if(start[12]==pruef){
        return 0;
    }
    return 1;
}

int main(){
    char* str;
    //scanf("%c",&str);
    printf("%d",isISB("3-442-54210-3"));
}