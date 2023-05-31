public class Kamera extends Artikel
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
