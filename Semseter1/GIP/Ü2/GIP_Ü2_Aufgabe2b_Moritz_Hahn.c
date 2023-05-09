#include <stdio.h> // Um die Methode "printf" zu verwenden, muss die Bibliothek "stdio.h" eingebunden/Importiert werden
int main()
{
    int n, i, q;
    printf("Geben Sie eine positive ganze Zahl ein: "); // In dieser Zeile hat der Letzte Anführungsstrich von dem String, welcher der Methode "printf" übergeben wurde vergessen
    scanf("%d", &n);
    q=0; //In dieser Zeile wurde die Syntax zum Definieren einer Variable vertauscht
    for (i = n; i > 0; i = i / 10)
    {
        q = q + (i % 10); // In dieser Zeile hat ein Semikolon an ende der Zeile gefehlt
    }
    printf("Die Quersumme von %d ist: %d\n", n,q); // In dieser Zeile wurden die Beiden Variablen n und q nicht mit einem Komma getrennt, somit ist die Syntax zur übergabe von variablen an Methoden Falsch
    return 0;
}