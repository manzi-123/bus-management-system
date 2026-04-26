public class Ticket {
    private String ticketId;
    private Passenger passenger;
    private BusManager bus;
    private int seatNumber;
    private double price;

    public Ticket() {
        this.ticketId = "";
        this.passenger = null;
        this.bus = null;
        this.seatNumber = 0;
        this.price = 0.0;
    }

    public Ticket(String ticketId, Passenger passenger, BusManager bus,
                  int seatNumber, double price) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.bus = bus;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getTicketId() { return ticketId; }
    public Passenger getPassenger() { return passenger; }
    public BusManager getBus() { return bus; }
    public int getSeatNumber() { return seatNumber; }
    public double getPrice() { return price; }

    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public void setBus(BusManager bus) { this.bus = bus; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    public void setPrice(double price) { this.price = price; }

    public double calculateTicketPrice(double distance) {
        if (bus != null) {
            this.price = bus.calculateFare(distance);
        }
        return this.price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + ticketId + "'" +
                ", passenger='" + (passenger != null ? passenger.getName() : "N/A") + "'" +
                ", bus='" + (bus != null ? bus.getBusNumber() : "N/A") + "'" +
                ", seat=" + seatNumber +
                ", price=$" + String.format("%.2f", price) +
                "}";
    }
}
