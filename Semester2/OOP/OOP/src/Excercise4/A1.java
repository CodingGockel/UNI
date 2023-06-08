package Excercise4;

class Auto
{
    public String kennzeichen;
    public int kilometer;
    public int sitze;
    public boolean antenne;
    public Auto()
    {
        this.kennzeichen = "J-AA 01";
        this.kilometer = 0;
        this.sitze = 5;
        this.antenne = false;
    }
    public Auto(int sitze)
    {
        this.kennzeichen = "J-AA 01";
        this.kilometer = 0;
        if(sitze == 2){
            this.sitze = sitze;
        }else{
            this.sitze = 5;
        }
        this.antenne = false;
    }
    public Auto(String kennzeichen)
    {
        this.kennzeichen = kennzeichen;
        this.kilometer = 0;
        this.sitze = 5;
        this.antenne = false;
    }
    public Auto(int sitze, String kennzeichen)
    {
        this.kennzeichen = kennzeichen;
        this.kilometer = 0;
        if(sitze == 2){
            this.sitze = sitze;
        }else{
            this.sitze = 5;
        }
        this.antenne = false;
    }
    public String getKennzeichen(){
        return this.kennzeichen;
    }
    public int getKilometerstand(){
        return this.kilometer;
    }
    public int getSitzplaetze(){
        return this.sitze;
    }
    public void fahre(int kilometer){
        this.kilometer += kilometer;
        System.out.println("Eine Strecke von " + kilometer + "wurde zurückgelegt");
    }
    public void fahreAntenneAus(){
        System.out.println("Fahre antenne aus");
        this.antenne = true;
    }
    public void fahreAntenneEin(){
        System.out.println("Fahre antenne ein");
        this.antenne = false;
    }
    public void bereiteWaschenVor(){
        this.fahreAntenneEin();
    }
    public void wasche(){
        this.bereiteWaschenVor();
        System.out.println("Auto wird gewaschen");
    }
    public String toString(){
        return "Kennzeichen: " + this.kennzeichen + "\n" + "Sitze: " + this.sitze + "\n" + "Kilometerstand: " + this.kilometer + "\n" + "Antenne ist ausgefahren: " + this.antenne + "\n";
    }
}
class PickUp extends Auto
{
    private int f;
    private int ladung;
    public PickUp(int f)
    {
        super(2);
        this.f = f;
        this.ladung = 0;
    }
    public PickUp(int f, String kennzeichen)
    {
        super(2,kennzeichen);
        this.f = f;
        this.ladung = 0;
    }
    public int getLadung(){
        return this.ladung;
    }
    public boolean beladen(int ladung){
        if(this.ladung + ladung <= this.f){
            System.out.println("Der Pick-Up wurde mit " + ladung + " ladung beladen.");
            this.ladung += ladung;
            return true;
        }
        return false;
    }
    public void entladen(int ladung){
        System.out.println("Der Pick-Up wurde mit " + ladung + " ladung entladen.");
        this.ladung -= ladung;
    }
    public void entladen(){
        this.entladen(this.ladung);
    }
    public void bereiteWaschenVor(){
        this.entladen();
        super.bereiteWaschenVor();
    }
    public String toString(){
        String ret = super.toString();
        ret += "Ladung : " + this.ladung + "\n" + "Fasungsvermögen: " + this.f + "\n";
        return ret;
    }
}
class AutoTest
{
    public Auto[] arr;
    public AutoTest(){
        arr = new Auto[6];
        arr[0] = new Auto();
        arr[1] = new Auto("J-SC 04");
        arr[2] = new Auto(2);
        arr[3] = new Auto(2,"K-JJ 99");
        arr[4] = new PickUp(500);
        arr[5] = new PickUp(500,"K-JJ 99");
    }
    private void main(){
        this.arr[0].fahre(30);
        this.arr[1].wasche();
        this.arr[1].fahreAntenneAus();
        this.arr[2].fahre(500);
        this.arr[3].fahreAntenneAus();
        this.arr[3].wasche();
        PickUp pickUp1 = (PickUp) this.arr[4];
        PickUp pickUp2 = (PickUp) this.arr[5];
        pickUp1.beladen(50);
        pickUp1.entladen(20);
        pickUp2.beladen(49);
        pickUp2.wasche();
        for(Auto a: this.arr){
            System.out.println(a.toString());
        }
    }
}

