#include <stdio.h>

int strLen(char* str){
    int i=0;
    while(*str){
        i++;
        *str++;
    }
    return i;
}

int strCount(char c, char* str){
    int i=0;
    while(*str){
        if(*str==c){
            i++;
        }
        *str++;
    }
    return i;
}

// char* stringCat(char* str1, char* str2){
//     int n= strLen(str1);
//     for (int i = 0; i < strLen(str2); i++){
//         str1[i+n]=str2[i];
//         printf("%c",str2[i]);
//     }
//     str1[n+strLen(str2)]='\0';
//     return str1;
// }

char* stringCat(char* str1, char* str2){
    int l= strLen(str1)+strLen(str2);
    char ret[l];
    for(int i=0; i<strLen(str1);i++){
        ret[i]=*str1;
        *str1++;
    }
    for(int i=strLen(str1); i<strLen(str2)+strLen(str1);i++){
        ret[i]=*str2;
        *str2++;
    }
    ret[l-1]='\0';
    return ret;
}

int main(){
    printf("%s",stringCat("Welt","Hallo"));
}