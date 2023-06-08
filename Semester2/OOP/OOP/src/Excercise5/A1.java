package Excercise5;
import java.lang.Math;
class Artikel
{
    int aktAnzahl;
    int minAnzahl;
    double nettoPreis;
    String name;
    int mwst;
    public Artikel(int aktAnzahl, int minAnzahl, double nettoPreis, String name, int mwst)
    {
        this.aktAnzahl = aktAnzahl;
        this.minAnzahl = minAnzahl;
        this.nettoPreis = nettoPreis;
        this.name = name;
        this.mwst = mwst;
    }
    public void print(){
        System.out.print("Artikel " + this.name + "\t" + this.aktAnzahl + "/" + this.minAnzahl + " Netto-Preis" + "\t" + this.nettoPreis);
    }
    public void printBestellung(){
        if(this.minAnzahl > this.aktAnzahl){
            double nettoGesamt = Math.round(((this.minAnzahl - this.aktAnzahl) * this.nettoPreis)*100.0)/100.0;
            double steuer = Math.round(((this.mwst * nettoGesamt)/100)*100.0)/100.0;
            double gesamt = Math.round((nettoGesamt + steuer)*100.0)/100.0;
            System.out.println(this.name + "\t ->" + (this.minAnzahl - this.aktAnzahl) + " * " + this.nettoPreis + " = " + nettoGesamt + "\t + " + steuer + " MWSt. (" + this.mwst + ")" + " macht gesamt " + gesamt);
        }else{
            System.out.println(this.name + "\t noch vorrätig");
        }
    }
}
class Audio extends Artikel
{
    private String beschreibung;
    public Audio(int a,int b, double c, String h, String beschreibung)
    {
        super(a,b,c,h,19);
        this.beschreibung = beschreibung;
    }
    @Override
    public void print(){
        super.print();
        System.out.print("\t(" + this.beschreibung + ")\n");
    }
}
class Buch extends Artikel
{
    private String beschreibung;
    public Buch(int a,int b, double c, String h, String beschreibung)
    {
        super(a,b,c,h,7);
        this.beschreibung = beschreibung;
    }
    @Override
    public void print(){
        super.print();
        System.out.print("\t(" + this.beschreibung + ")\n");
    }
}
class Kamera extends Artikel
{
    private String beschreibung;
    public Kamera(int a,int b, double c, String h, String beschreibung)
    {
        super(a,b,c,h,19);
        this.beschreibung = beschreibung;
    }
    @Override
    public void print(){
        super.print();
        System.out.print("\t(" + this.beschreibung + ")\n");
    }
}
class Test
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


