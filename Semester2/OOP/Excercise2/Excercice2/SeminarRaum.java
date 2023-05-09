public class SeminarRaum
{
    int plätze;
    Adresse adresse;
    Übung[] übungen;
    public SeminarRaum(int plz, Adresse adr, Übung[] übungen){
        this.plätze = plz;
        this.übungen = übungen;
        this.adresse = adr;
    }
    public int getPlätze(){
        return this.plätze;
    }
    public Adresse getAdresse(){
        return this.adresse;
    }
    public Übung[] getÜbungen(){
        return this.übungen;
    }
}
