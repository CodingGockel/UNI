#include <stdio.h>
int main(){
    const float CONST= 5.0/9.0;
    int fahrenheit;
    printf("please enter Fahrenheit: ");
    scanf("%d",&fahrenheit);
    float celsius= (fahrenheit-32)*CONST;
    printf(5/9);
    printf("%d grad Fahrenheit are %d grad Celsius",fahrenheit,(int)celsius);
}