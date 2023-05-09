#include <stdio.h>
#include <stdlib.h>

int add(int a, int b){
    if(a==0&&b==0){
        return 0;
    }
    if(a==0){
        return 1+add(a,b-1);
    }
    if(b==0){
        return 1+add(a-1,b);
    }
    return 1+add(a-1,b-1)+1;
}
int mult(int a, int b){
    if(a==0||b==0){
        return 0;
    }
    if(a==1){
        return b;
    }
    if(b==1){
        return a;
    }
    return b+mult(a-1,b);
}
int main() {
    int a,b;
    printf("gib a und b ein:\n");
    scanf("%d %d",&a,&b);
    printf("die summe aus %d+%d=%d\n",a,b,add(a,b));
    printf("gib a und b ein:\n");
    scanf("%d %d",&a,&b);
    printf("das produkt aus %dx%d=%d",a,b,mult(a,b));
    return 0;
}


