#include <stdio.h>

int main(){
    int i = 5;
    int j = 7;
    int * p = &i;
    int * q = &j;

    i = *p * *q;
    printf("%d %d %p %d %p %d\n",i,j,p,*p,q,*q);
    *p = 12;
    printf("%d %d %p %d %p %d\n",i,j,p,*p,q,*q);
    q = p;
    printf("%d %d %p %d %p %d\n",i,j,p,*p,q,*q);
    j = i / 2;
    printf("%d %d %p %d %p %d\n",i,j,p,*p,q,*q);
    (*q)++;
    printf("%d %d %p %d %p %d\n",i,j,p,*p,q,*q);
    j = *q;
    printf("%d %d %p %d %p %d\n",i,j,p,*p,q,*q);
}