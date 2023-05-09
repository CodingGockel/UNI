#include <stdio.h>
int main()
{
    int n;
    printf("Geben Sie eine positive ganze Zahl ein: "); //Hier hat die letzte Klammer von dem AUfruf der "printf" Methode gefehlt
    scanf("%d", &n);
    printf("Die Fakultaet von %d ist: ", n);
    int f = 1;
    while (n > 1) //Hier hat die letzte KLammer des While-Schleifen Methoden Kopfes gefehlt
    {
        f = f * n;
        n = n - 1;
    }
    printf("%d\n", f);
    return 0; //Hier hat am ende der Zeile ein Semikolon gefehlt
}
