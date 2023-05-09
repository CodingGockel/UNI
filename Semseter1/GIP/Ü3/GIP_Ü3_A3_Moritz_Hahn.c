#include <stdio.h>
#include <math.h> 
int main(){
    int x1, y1, z1,x2,y2,z2;
    printf("please enter the two cordinates of the corners from the quader (in the form:x1 y1 z1 x2 y2 z2):\n");
    scanf("%d%d%d%d%d%d", &x1, &y1, &z1, &x2, &y2, &z2);
    int const LENGTH=fabs(y1-y2);
    int const WIDTH=fabs(x1-x2);
    int const HIGTH=fabs(z1-z2);
    int Volumen=LENGTH*WIDTH*HIGTH;
    int Oberflaeche=2*(LENGTH*WIDTH+HIGTH*LENGTH+WIDTH*HIGTH);
    int gesamtLaengeAllerKanten=6*(LENGTH*WIDTH*HIGTH);
    printf("\n The Volume is: %d\n The Oberflaeche is: %d\n The Gesamtlaenge aller Kanten is: %d",Volumen,Oberflaeche,gesamtLaengeAllerKanten);
}