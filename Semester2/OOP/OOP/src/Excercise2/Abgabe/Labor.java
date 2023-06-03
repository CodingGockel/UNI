public class Labor
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