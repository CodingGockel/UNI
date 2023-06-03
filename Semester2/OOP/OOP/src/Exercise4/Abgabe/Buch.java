public class Buch extends Artikel
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
