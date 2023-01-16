int solve(double a, double b, double c, double *x1, double *x2);
#include <stdio.h>
#include <math.h>
#include <stdio.h>

int main(void){
    double a, b, c;
    scanf("%lf %lf %lf", &a, &b, &c);
    double x1, x2;
    int anzahl = solve(a, b, c, &x1, &x2);
    if (!anzahl)
    printf("keine L¨osung");
    else if (anzahl == 1)
    printf("eine L¨osung x: %lf", x1);
    else if (anzahl > 1)
    printf("zwei L¨osungen x1: %lf x2: %lf", x1, x2);
}

int solve(double a, double b, double c, double *x1, double *x2){
    if((pow(b,2)-(4*a*c)/(2*a))<0){
        return 0;
    }
    *x1= ((-b)+sqrt(pow(b,2)-(4*a*c)))/(2*a);
    *x2= ((-b)-sqrt(pow(b,2)-(4*a*c)))/(2*a);
    if(&x1==&x2){
        return 1;
    }
    return 2;
}

