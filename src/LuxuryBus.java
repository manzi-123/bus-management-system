public class LuxuryBus extends BusManager {
    private boolean hasWifi;
    private boolean hasRecliningSeats;

    public LuxuryBus() {
        super();
        this.hasWifi = false;
        this.hasRecliningSeats = false;
    }

    public LuxuryBus(String vehicleId, String vehicleName, int capacity, String fuelType,
                     String currentLocation, String status, String driverName,
                     String busNumber, String routeAssigned,
                     boolean hasWifi, boolean hasRecliningSeats) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status,
                driverName, busNumber, routeAssigned);
        this.hasWifi = hasWifi;
        this.hasRecliningSeats = hasRecliningSeats;
    }

    public boolean isHasWifi() { return hasWifi; }
    public boolean isHasRecliningSeats() { return hasRecliningSeats; }
    public void setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi; }
    public void setHasRecliningSeats(boolean hasRecliningSeats) { this.hasRecliningSeats = hasRecliningSeats; }

    @Override
    public void startVehicle() {
        setStatus("Active");
        System.out.println("Luxury Bus " + getBusNumber() + " started. Premium services active.");
        if (hasWifi) System.out.println("  WiFi enabled.");
        if (hasRecliningSeats) System.out.println("  Reclining seats ready.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.40;
    }

    @Override
    public double calculateFare(double distance) {
        double base = distance * 1.50;
        if (hasWifi) base += 3.0;
        if (hasRecliningSeats) base += 2.0;
        return base;
    }

    @Override
    public String generateVehicleReport() {
        return "=== Luxury Bus Report ===\n" +
                "Bus Number    : " + getBusNumber() + "\n" +
                "Driver        : " + getDriverName() + "\n" +
                "WiFi          : " + (hasWifi ? "Yes" : "No") + "\n" +
                "Reclining Seats: " + (hasRecliningSeats ? "Yes" : "No") + "\n" +
                "Capacity      : " + getCapacity() + "\n" +
                "Booked        : " + getBookedSeatCount() + "/" + getCapacity() + "\n" +
                "Status        : " + getStatus();
    }

    @Override
    public String toString() {
        return "LuxuryBus{" +
                "id='" + getVehicleId() + "'" +
                ", busNumber='" + getBusNumber() + "'" +
                ", driver='" + getDriverName() + "'" +
                ", wifi=" + hasWifi +
                ", recliningSeats=" + hasRecliningSeats +
                ", seats=" + getBookedSeatCount() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
