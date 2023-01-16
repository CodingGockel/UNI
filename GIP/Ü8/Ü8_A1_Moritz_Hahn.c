#include <stdio.h>
int main()
{
int var = 10;
int *p;
p = &var;
printf ( "Ausgabe 1: %p \n", &var );
printf ( "Ausgabe 2: %d \n", *p );
printf ( "Ausgabe 3: %d \n", *(&var));
printf ( "Ausgabe 4: %p \n", &p );
return 0;
}