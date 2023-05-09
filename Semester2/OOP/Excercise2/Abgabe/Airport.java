import java.util.*;
public class Airport
{
    public Flight[] flights; 
    public int maxFlights;
    public Airport(int maxFlights)
    {
        this.flights = new Flight[maxFlights];
        this.maxFlights = maxFlights;
    }
    
    public void addNewFLight(Flight flight){
        Boolean h = true;
        Boolean h2 = true;
        for(int i = 0; i < this.flights.length; i++){
            if(this.flights[i] != null){
                if(this.flights[i].flightNumber == flight.flightNumber){
                    System.out.println("Flugnummer schon vorhanden");
                    h = false;
                }
            }
        }
        if(h){
            for(int i = 0; i < this.flights.length; i++){
                if(this.flights[i] == null){
                    this.flights[i] = flight;
                    h2 = false;
                    break;
                }
            }
        }
        if(h2 && h){
            System.out.println("Maximale Anzahl an Flügen erreicht");
        }
    }
    public void removeFlight(int flightNumber){
        for(int i = 0; i < this.flights.length; i++){
                if(this.flights[i].flightNumber == flightNumber){
                    this.flights[i] = null;
                    break;
                }
            }
    }
    public void listDeparturesOnScreen(){
        System.out.println("------------------------------------------------------------------------------------------");
        for(int i = 0; i < this.flights.length; i++){
            if(this.flights[i] != null){
                if(!this.flights[i].inOut){
                    System.out.println("Flugnummer: "+ this.flights[i].flightNumber + " Abflugzeit: " + this.flights[i].time + " Gate: " + this.flights[i].gate + " Zielort: " + this.flights[i].location); 
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }
    public void listArrivalsOnScreen(){
        System.out.println("------------------------------------------------------------------------------------------");
        for(int i = 0; i < this.flights.length; i++){
            if(this.flights[i] != null){
                if(this.flights[i].inOut){
                    System.out.println("Flugnummer: "+ this.flights[i].flightNumber + " Abflugzeit: " + this.flights[i].time + " Gate: " + this.flights[i].gate + " Zielort: " + this.flights[i].location); 
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
