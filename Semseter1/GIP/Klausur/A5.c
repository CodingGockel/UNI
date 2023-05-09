#include <stdio.h>

int countChar(char* str,char c){
    int i=0;
    while(*str){
        if(*str==c){
            i++;
        }
        *str++;
    }
    return i;
}

char maxChar(char* str){
    char c;
    int max=-1;
    while(*str){
        if(countChar(str,*str)>max){
            max=countChar(str,*str);
            c=*str;
        }
        *str++;
    }
    return c;
}   

int maxCount(char* str){
    char c;
    int max=-1;
    char * start=str;
    while(*str++){
        if(countChar(start,*str)>max){
            max=countChar(start,*str);
            c=*str;
        }
    }
    return max;
}

int main(){
    int ct = countChar("Hallo Welt",'l');
    printf("Zeichenkette enthalt %d mal das l\n", ct);
    char c=maxChar("Hallo Welt");
    printf("%c kommt am haufigsten vor.\n", c);
    int maxct = maxCount("Hallo Welt");
    printf("Das haufigste Zeichen kommt %d mal vor.\n", maxct);
}