package Excercise3;
class Einwohner
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
class Adel extends Einwohner
{
    public Adel()
    {

    }
    int steuer(){
        if(super.steuer() <= 20){
            return 20;
        }
        return super.steuer();
    }
}
class Bauer extends Einwohner
{
    public Bauer(){

    }
}
class König extends Einwohner
{
    public König()
    {

    }
    int zuVersteuerndesEinkommen(){
        return 0;
    }
    int steuer(){
        return 0;
    }
}
class Leibeigener extends Bauer
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
