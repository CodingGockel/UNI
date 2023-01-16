double f1(double x, double y);
double f2(double x, double y);
#include <stdio.h>
#include <math.h>
#include <stdio.h>

double main(void){
    printf("%f\n",f1(1.0,2.0));
    return 0;
}

double f1(double x, double y){
    if((x-y)==0){
        printf("außerhalb des def bereiches!\n");
        return NAN;
    }
    printf("%f\n",(x+y)/(x-y));
    return (x+y)/(x-y);
}
double f2(double x, double y){
    if((x*x+y*y)<0){
        printf("außerhalb des def bereichs!\n");
        return NAN;
    }
    printf("%lf\n",sqrt((x*x+y*y)));
    return sqrt((x*x+y*y));
}
