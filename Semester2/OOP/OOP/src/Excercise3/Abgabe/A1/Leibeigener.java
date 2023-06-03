public class Leibeigener extends Bauer
{
    public Leibeigener()
    {
        
    }
    int zuVersteuerndesEinkommen(){
        if(this.einkommen <= 12){
            return 0;
        }
        return this.einkommen - 12;
    }
    int steuer(){
        if(this.zuVersteuerndesEinkommen() == 0){
            return 0;
        }
        return super.steuer();
    }
}
