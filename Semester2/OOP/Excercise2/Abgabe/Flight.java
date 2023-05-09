class Flight {
    int flightNumber; 
    String location; 
    String gate; 
    String time; 
    boolean inOut;
    public Flight(int flightNumber, String location, String gate, String time, Boolean inOut){
        this.flightNumber = flightNumber; 
        this.location = location; 
        this.gate = gate; 
        this.time = time; 
        this.inOut = inOut;
    }
}