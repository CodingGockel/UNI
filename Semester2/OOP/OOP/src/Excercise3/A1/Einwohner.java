public class Einwohner
{
    int einkommen;
    public Einwohner()
    {
        
    }
    int zuVersteuerndesEinkommen(){
        return this.einkommen;
    }
    int steuer(){
        if(((this.zuVersteuerndesEinkommen() * 10) /100) < 1){
            return 1;
        }
        return (this.zuVersteuerndesEinkommen() * 10) /100;
    }
    void setEinkommen(int einkommen){
        this.einkommen = einkommen;
    }
}
