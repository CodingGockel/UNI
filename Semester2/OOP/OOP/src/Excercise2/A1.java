package Excercise2;

class Adresse
{
    String straße;
    String plz;
    String ort;
    public Adresse(String straße, String plz, String ort){
        this.straße = straße;
        this.plz = plz;
        this.ort = ort;
    }
    public String getStraße(){
        return this.straße;
    }
    public String getplz(){
        return this.plz;
    }
    public String getOrt(){
        return this.ort;
    }
}
class Hörsaal
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
class SeminarRaum
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
class Labor
{
    int plätze;
    Adresse adresse;
    Praktika[] praktikas;
    public Labor(int plz, Adresse adr, Praktika[] praktikas){
        this.plätze = plz;
        this.praktikas = praktikas;
        this.adresse = adr;
    }
    public int getPlätze(){
        return this.plätze;
    }
    public Adresse getAdresse(){
        return this.adresse;
    }
    public Praktika[] getPraktikas(){
        return this.praktikas;
    }
}
class Praktika{

}
class Vorlesung{

}
class Übung{

}
