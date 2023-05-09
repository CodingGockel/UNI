#include <stdio.h>
#include <math.h>

int main(){
    double k0,kn,n,p;
    printf("Bitte geben sie Ihr Startkapital, Zinssatz, lufzeit an:\n");
    scanf("%lf%lf%lf",&k0,&p,&n);
    printf("-----------------------------------------------------------------------------------\n");
    for(int i=1;i<=n;i++){
        kn=(k0*pow(1+p/100,i));
        printf("| Startkaptal: %.2lf | Zinssatz: %.2lf | Jahr: %d | Kapital im Jahr %d : %.2lf |\n",k0,p,i,i,kn);
        printf("-----------------------------------------------------------------------------------\n");
    }
    return 0;
}