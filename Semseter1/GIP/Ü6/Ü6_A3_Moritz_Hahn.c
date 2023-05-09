#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main(){
    double x,min,max,max2,gesamt,anzahl;
    x=0.0;
    min=0.0;
    do{
        printf("gebe deinen wert ein:\n");
        scanf("%lf",&x);
        if(x==0.0){
            break;
        }
        if(min==0.0){
            min=x;
        }
        else if(min>x){
            min=x;
        }
        if(max<x){
            max2=max;
            max=x;
        }else if(max2<x){
            max2=x;
        }
        gesamt+=x;
        anzahl++;
    }while(x>0);
    double mittlereWeite= gesamt/anzahl;
    double diffMinMax= max-min;
    printf("anzahl der Sprünge: %0.0lf\n größte weite: %lf\n 2. größte weite: %lf\n geringste weite: %lf\n mittlereweite: %lf\n diiferenz zwischen min und max: %lf\n",anzahl,max,max2,min,mittlereWeite,diffMinMax);
    return 0;
}