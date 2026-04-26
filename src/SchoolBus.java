public class SchoolBus extends BusManager {
    private String schoolName;

    public SchoolBus() {
        super();
        this.schoolName = "";
    }

    public SchoolBus(String vehicleId, String vehicleName, int capacity, String fuelType,
                     String currentLocation, String status, String driverName,
                     String busNumber, String routeAssigned, String schoolName) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status,
                driverName, busNumber, routeAssigned);
        this.schoolName = schoolName;
    }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    @Override
    public void startVehicle() {
        setStatus("Active");
        System.out.println("School Bus " + getBusNumber() + " started for " + schoolName + ".");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.32;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.20;
    }

    @Override
    public boolean checkAvailability() {
        return getBookedSeatCount() < getCapacity() && "Active".equals(getStatus());
    }

    @Override
    public String toString() {
        return "SchoolBus{" +
                "id='" + getVehicleId() + "'" +
                ", busNumber='" + getBusNumber() + "'" +
                ", driver='" + getDriverName() + "'" +
                ", school='" + schoolName + "'" +
                ", seats=" + getBookedSeatCount() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
