public class TouristBus extends BusManager {
    private String tourPackage;

    public TouristBus() {
        super();
        this.tourPackage = "Standard";
    }

    public TouristBus(String vehicleId, String vehicleName, int capacity, String fuelType,
                      String currentLocation, String status, String driverName,
                      String busNumber, String routeAssigned, String tourPackage) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status,
                driverName, busNumber, routeAssigned);
        this.tourPackage = tourPackage;
    }

    public String getTourPackage() { return tourPackage; }
    public void setTourPackage(String tourPackage) { this.tourPackage = tourPackage; }

    @Override
    public void startVehicle() {
        setStatus("Active");
        System.out.println("Tourist Bus " + getBusNumber() + " started. Package: " + tourPackage);
    }

    @Override
    public double calculateFare(double distance) {
        double multiplier = 1.0;
        if ("Premium".equalsIgnoreCase(tourPackage)) {
            multiplier = 2.0;
        } else if ("Budget".equalsIgnoreCase(tourPackage)) {
            multiplier = 0.70;
        }
        return distance * multiplier;
    }

    @Override
    public String generateVehicleReport() {
        return "=== Tourist Bus Report ===\n" +
                "Bus Number  : " + getBusNumber() + "\n" +
                "Driver      : " + getDriverName() + "\n" +
                "Tour Package: " + tourPackage + "\n" +
                "Capacity    : " + getCapacity() + "\n" +
                "Booked      : " + getBookedSeatCount() + "/" + getCapacity() + "\n" +
                "Status      : " + getStatus();
    }

    @Override
    public String performMaintenanceCheck() {
        return "Tourist Bus " + getBusNumber() + " check: Tour equipment inspected. Package: " + tourPackage;
    }

    @Override
    public String toString() {
        return "TouristBus{" +
                "id='" + getVehicleId() + "'" +
                ", busNumber='" + getBusNumber() + "'" +
                ", driver='" + getDriverName() + "'" +
                ", tourPackage='" + tourPackage + "'" +
                ", seats=" + getBookedSeatCount() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
