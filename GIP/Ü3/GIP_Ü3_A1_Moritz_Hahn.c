#include <stdio.h>
#include <stdlib.h>
int main(void){
    float ans1;
    int ans2; 
    char ans3;
    int ans4;
    char ans5;
    printf("what is pi (round on 3 decimalplaces and youse point as comma)? ");
    scanf(" %f",&ans1);
    fflush(stdin);
    printf("what is 5+4? ");
    scanf(" %d",&ans2);
    fflush(stdin);
    printf("what is the second letter in the alphabet? ");
    scanf(" %c",&ans3);
    fflush(stdin);
    printf("what is the squareroot of '4'? ");
    scanf(" %d",&ans4);
    fflush(stdin);
    printf("what is the first letter of the Mc'Donalds logo? ");
    scanf(" %c",&ans5);
    fflush(stdin);

    printf(" %c\n %d\n %c\n %d\n %0.001f\n", ans5,ans4,ans3,ans2,ans1);
    return 0;
}