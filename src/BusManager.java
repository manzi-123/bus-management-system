import java.util.ArrayList;

public class BusManager extends Vehicle implements Bookable, Trackable {
    private String driverName;
    private String busNumber;
    private String routeAssigned;
    private ArrayList<Integer> bookedSeats;
    private ArrayList<String> cancelledBookings;
    private double farePerKm;

    public BusManager() {
        super();
        this.driverName = "";
        this.busNumber = "";
        this.routeAssigned = "";
        this.bookedSeats = new ArrayList<Integer>();
        this.cancelledBookings = new ArrayList<String>();
        this.farePerKm = 0.5;
    }

    public BusManager(String vehicleId, String vehicleName, int capacity, String fuelType,
                      String currentLocation, String status, String driverName,
                      String busNumber, String routeAssigned) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status);
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeAssigned = routeAssigned;
        this.bookedSeats = new ArrayList<Integer>();
        this.cancelledBookings = new ArrayList<String>();
        this.farePerKm = 0.5;
    }

    public String getDriverName() { return driverName; }
    public String getBusNumber() { return busNumber; }
    public String getRouteAssigned() { return routeAssigned; }
    public ArrayList<Integer> getBookedSeats() { return bookedSeats; }
    public double getFarePerKm() { return farePerKm; }
    public int getBookedSeatCount() { return bookedSeats.size(); }

    public void setDriverName(String driverName) { this.driverName = driverName; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public void setRouteAssigned(String routeAssigned) { this.routeAssigned = routeAssigned; }
    public void setFarePerKm(double farePerKm) { this.farePerKm = farePerKm; }

    @Override
    public void startVehicle() {
        setStatus("Active");
        System.out.println("Bus " + busNumber + " has started.");
    }

    @Override
    public void stopVehicle() {
        setStatus("Stopped");
        System.out.println("Bus " + busNumber + " has stopped.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.30;
    }

    @Override
    public boolean checkAvailability() {
        return bookedSeats.size() < getCapacity() && "Active".equals(getStatus());
    }

    @Override
    public void assignRoute(String routeId) {
        this.routeAssigned = routeId;
        System.out.println("Bus " + busNumber + " assigned to route " + routeId);
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
        System.out.println("Bus " + busNumber + " location updated to: " + location);
    }

    @Override
    public String performMaintenanceCheck() {
        return "Bus " + busNumber + " maintenance check: All systems operational.";
    }

    @Override
    public String generateVehicleReport() {
        return "=== Vehicle Report ===\n" +
                "Bus Number  : " + busNumber + "\n" +
                "Driver      : " + driverName + "\n" +
                "Route       : " + (routeAssigned.isEmpty() ? "Not Assigned" : routeAssigned) + "\n" +
                "Capacity    : " + getCapacity() + "\n" +
                "Booked Seats: " + bookedSeats.size() + "/" + getCapacity() + "\n" +
                "Status      : " + getStatus() + "\n" +
                "Location    : " + getCurrentLocation();
    }

    @Override
    public boolean bookSeat(int seatNumber, Passenger passenger) {
        if (seatNumber < 1 || seatNumber > getCapacity()) {
            System.out.println("Error: Seat number must be between 1 and " + getCapacity() + ".");
            return false;
        }
        if (bookedSeats.contains(seatNumber)) {
            System.out.println("Error: Seat " + seatNumber + " is already booked.");
            return false;
        }
        bookedSeats.add(seatNumber);
        System.out.println("Seat " + seatNumber + " booked for " + passenger.getName() + ".");
        return true;
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        cancelledBookings.add(bookingId);
        System.out.println("Booking " + bookingId + " cancelled on bus " + busNumber + ".");
        return true;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * farePerKm;
    }

    @Override
    public String trackLocation() {
        return "Bus " + busNumber + " is currently at: " + getCurrentLocation();
    }

    @Override
    public void updateStatus(String newStatus) {
        setStatus(newStatus);
        System.out.println("Bus " + busNumber + " status updated to: " + newStatus);
    }

    public boolean isSeatBooked(int seatNumber) {
        return bookedSeats.contains(seatNumber);
    }

    public void releaseSeat(int seatNumber) {
        bookedSeats.remove(Integer.valueOf(seatNumber));
    }

    @Override
    public String toString() {
        return "BusManager{" +
                "id='" + getVehicleId() + "'" +
                ", name='" + getVehicleName() + "'" +
                ", busNumber='" + busNumber + "'" +
                ", driver='" + driverName + "'" +
                ", route='" + (routeAssigned.isEmpty() ? "None" : routeAssigned) + "'" +
                ", seats=" + bookedSeats.size() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
