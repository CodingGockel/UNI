public class Hörsaal
{
    int plätze;
    Adresse adresse;
    Vorlesung[] vorlesungen;
    public Hörsaal(int plz, Adresse adr, Vorlesung[] vlg){
        this.plätze = plz;
        this.vorlesungen = vlg;
        this.adresse = adr;
    }
    public int getPlätze(){
        return this.plätze;
    }
    public Adresse getAdresse(){
        return this.adresse;
    }
    public Vorlesung[] getVorlesungen(){
        return this.vorlesungen;
    }
}