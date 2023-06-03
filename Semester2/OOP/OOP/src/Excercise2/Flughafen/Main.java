public class Main
{
    Airport airport;
    public Main(){
        this.airport = new Airport(5);
    }
    public void test(){
        for(int i=1;i<=5;i++){
            this.airport.addNewFLight(new Flight(i,"Mainz","3","22:30",true));
        }
        this.airport.listArrivalsOnScreen();
        this.airport.removeFlight(3);
        this.airport.listArrivalsOnScreen();
        this.airport.addNewFLight(new Flight(1,"Hamburg","3","22:30",false));
        this.airport.addNewFLight(new Flight(7,"Hamburg","3","22:30",false));
        this.airport.listArrivalsOnScreen();
        this.airport.listDeparturesOnScreen();
    }
}