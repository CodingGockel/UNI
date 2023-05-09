
public class Adresse
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
