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
        System.out.print("Artikel " + this.name + "\t\t" + this.minAnzahl + "/" + this.aktAnzahl + " Netto-Preis" + "\t" + this.nettoPreis);
    }
    public void printBestellung(int anzahl){
        if(this.minAnzahl - anzahl >= 0){
            double nettoGesamt = anzahl * this.nettoPreis;
            double steuer = (this.mwst * nettoGesamt)/100;
            double gesamt = nettoGesamt + steuer;
            System.out.println(this.name + "\t\t ->" + anzahl + " * " + this.nettoPreis + " = " + nettoGesamt + "\t + " + steuer + " MWSt. (" + this.mwst + ")" + " macht gesamt " + gesamt);
        }else{
            System.out.println(this.name + "\t\t nicht verfügbar");
        }
    }
}
