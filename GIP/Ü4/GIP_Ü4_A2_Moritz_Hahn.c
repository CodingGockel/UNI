#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int start, ziel;
    printf("\nStarthaltestelle: ");
    scanf("%d", &start);
    printf("\nZielhaltestelle: ");
    scanf("%d", &ziel);
    if (start == ziel)
    {
        printf("\nStart- und Endhaltestelle dürfen nicht die selbe sein.");
        return 400;
    }
    if ((start < 11 && start != 0) || (ziel < 11 && ziel != 0) || start > 55 || ziel > 55)
    {
        printf("\nHaltestelle ist nicht vorhanden");
        return 404;
    }
    if (start%10 > 5 || ziel%10 > 5)
    {
        printf("\nHaltestelle ist nicht vorhanden.");
        return 404;
    }
    int kurzstrecke = 0;
    int benachbartSelbeLinie = (abs(start-ziel) == 1);
    int benachbartRing = ((start % 10 == 2 && ziel % 10 == 2) && abs(start-ziel) == 10);
    int benachbartZentral = (start == 0 || ziel == 0) && (start%10 == 1 || ziel%10 == 1);
    if (benachbartSelbeLinie || benachbartRing || benachbartZentral)
    {
        if (!(((ziel == 21 || start == 21) && (ziel == 0 || start == 0)) || ((ziel == 42 || start == 42) && (ziel == 52 || start == 52))))
        {
            kurzstrecke = 1;
        }
    }
    int endhaltestellen = 0;
    if (start%10 == 5)
    {
        endhaltestellen += 1;
    }
    if (ziel%10 == 5)
    {
        endhaltestellen += 1;
    }
    int zonenwechsel;
    int startInStadt = start%10 <= 2;
    int zielInStadt = ziel%10 <= 2;
    if (startInStadt && zielInStadt)
    {
        zonenwechsel = 0;
    }
    if (startInStadt != zielInStadt)
    {
        zonenwechsel = 1;
    }

    if (!startInStadt && !zielInStadt)
    {
        if (abs(start-ziel) <= 2)
        {
            zonenwechsel = 0;
        }
        else
        {
            zonenwechsel = 2;
        }
    }
    int preis;
    preis += 3-kurzstrecke;
    preis += endhaltestellen;
    preis += zonenwechsel;
    printf("\nTicketpreis: %d€", preis);
    return 0;
}
