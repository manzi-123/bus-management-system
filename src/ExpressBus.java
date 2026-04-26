public class ExpressBus extends BusManager {
    private double expressFee;

    public ExpressBus() {
        super();
        this.expressFee = 5.0;
    }

    public ExpressBus(String vehicleId, String vehicleName, int capacity, String fuelType,
                      String currentLocation, String status, String driverName,
                      String busNumber, String routeAssigned, double expressFee) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status,
                driverName, busNumber, routeAssigned);
        this.expressFee = expressFee;
    }

    public double getExpressFee() { return expressFee; }
    public void setExpressFee(double expressFee) { this.expressFee = expressFee; }

    @Override
    public void startVehicle() {
        setStatus("Active");
        System.out.println("Express Bus " + getBusNumber() + " started. Express service activated.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.28;
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * 0.60) + expressFee;
    }

    @Override
    public String performMaintenanceCheck() {
        return "Express Bus " + getBusNumber() + " check: Engine OK. Express systems operational.";
    }

    @Override
    public String toString() {
        return "ExpressBus{" +
                "id='" + getVehicleId() + "'" +
                ", busNumber='" + getBusNumber() + "'" +
                ", driver='" + getDriverName() + "'" +
                ", expressFee=$" + String.format("%.2f", expressFee) +
                ", seats=" + getBookedSeatCount() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
