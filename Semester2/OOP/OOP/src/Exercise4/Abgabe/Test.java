public class Test
{
    public static void main(String args[]){
        Artikel arts[] = new Artikel[6];
        arts[0] = new Buch(4,10,19.90,"Java für Anfänger", "Artikel ist ein Buch, hat 234 Seiten");
        arts[1] = new Audio(10,30,29.90,"Illuminati","Artikel ist Audio, besteht aus 6 Elementen");
        arts[2] = new Kamera(2,2,500.0,"Canon-500","Artikel ist eine Kamera, hat kein Objektiv");
        arts[3] = new Audio(4,2,5.0,"Traumland","Artikel ist Audio, besteht aus 1 Elementen");
        arts[4] = new Kamera(1,2,450.0,"Nikon-400","Artikel ist eine Kamera, hat ein Objektiv");
        arts[5] = new Buch(2,10,24.90,"Learning Java","Artikel ist ein Buch, hat 198 Seiten");
        printArtikel(arts);
    }
    public static void printArtikel(Artikel arts[]) {
        System.out.println("Artikelliste:");
        for (int i = 0; i < arts.length; i++) {
            arts[i].print(); System.out.println();
        }
        System.out.println("\nBestellung:");
        for (int i = 0; i < arts.length; i++) {
            arts[i].printBestellung(); System.out.println();
        }
    }
}
