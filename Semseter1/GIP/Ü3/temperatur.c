#include <stdio.h>
//GIP_Ü3_A2_Moritz_Hahn
int main(){
    const float CONST= 5.0/9.0;
    int n;
    printf("please enter Fahrenheit: \n");
    scanf("%d",&n);
    float celsius= (n-32)*CONST;
    printf(5/9);
    printf("%d grad Fahrenheit are %d grad Celsius",n,(int)celsius);
}