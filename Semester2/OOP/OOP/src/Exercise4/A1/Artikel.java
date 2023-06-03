import java.lang.Math;
public class Artikel
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
