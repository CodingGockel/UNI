#include <stdio.h>
#define _USE_MATH_DEFINES
#include <math.h>

int main(){
    float n;
    printf("Bitte gebe deine genauigkeit an:\n");
    scanf("%f",&n);
    float p=3.0;
    float sum=4.0;
    float d=4/3;
    int i=1;
    while(d>n){
        d=4/p;
        p+=2.0;
        if(i%2==0){
            sum+=d;
        }else{
            sum-=d;
        }
        i++;
    }
    float pi=M_PI;
    float fehler=sum-pi;
    printf("Fehler: %f\nPi errechnet: %f\nPi Math Libary: %f",fehler,sum,pi);
    
}