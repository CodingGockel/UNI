#include <stdio.h>
int main(){
    int m,n,x,y,z,a;
    printf("gebe die variablen: m,n,x,y,z und a an (in der Form:m n x y z a)\n");
    scanf("%d%d%d%d%d%d",&m,&n,&x,&y,&z,&a);
    if(m<=10&&n!=9){
        printf("1. :True\n");
    }else{
        printf("1. :False\n");
    }
    if((x%5==0)&&(y%5==0)&&(z%5==0)){
        printf("2. :True\n");
    }else{
        printf("2. :False\n");
    }
    if(((a<10)&&(a>1))||(a<-7)){
        printf("3. :True\n");
    }else{
        printf("3. :False\n");
    }
    if(1==1){
        printf("4. :True");
    }else{
        printf("4. :False");
    }   
}