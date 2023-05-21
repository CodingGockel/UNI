public class Adel extends Einwohner
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
