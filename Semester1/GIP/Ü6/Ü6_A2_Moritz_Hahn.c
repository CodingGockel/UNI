#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main(){
    double x1,y1,x2,y2,x3,y3;
    printf("bitte gib deine punkte an (x1 y1 x2 y2 x3 y3):\n");
    scanf("%lf%lf%lf%lf%lf%lf",&x1,&y1,&x2,&y2,&x3,&y3);
    if((x1==x2&&x1==x3)||(y1==y2&&y1==y3)||((x1==x2)&&(y1==y2))||((x1==x3)&&(y1==y3))||((x3==x2)&&(y3==y2))){
        printf("0\n");
        return 0;
    }
    double a= sqrt(abs(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2))));
    double b= sqrt(abs(((x1-x3)*(x1-x3))+((y1-y3)*(y1-y3))));
    double c= sqrt(abs(((x3-x2)*(x3-x2))+((y3-y2)*(y3-y2))));
    double s=(a+b+c)/2;
    double A=sqrt(s*(s-a)*(s-b)*(s-c));
    printf("a:%lf b: %lf c: %lf s:%lf ",a,b,c,s);
    printf("Flächeninhalt= %lf \n",A);


}