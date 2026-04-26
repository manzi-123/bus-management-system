public class CityBus extends BusManager {
    private boolean hasAirConditioning;

    public CityBus() {
        super();
        this.hasAirConditioning = false;
    }

    public CityBus(String vehicleId, String vehicleName, int capacity, String fuelType,
                   String currentLocation, String status, String driverName,
                   String busNumber, String routeAssigned, boolean hasAirConditioning) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status,
                driverName, busNumber, routeAssigned);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean isHasAirConditioning() { return hasAirConditioning; }
    public void setHasAirConditioning(boolean hasAirConditioning) { this.hasAirConditioning = hasAirConditioning; }

    @Override
    public void startVehicle() {
        setStatus("Active");
        System.out.println("City Bus " + getBusNumber() + " started." +
                (hasAirConditioning ? " AC is on." : " No AC."));
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.35;
    }

    @Override
    public double calculateFare(double distance) {
        double base = distance * 0.40;
        return hasAirConditioning ? base + 1.0 : base;
    }

    @Override
    public String performMaintenanceCheck() {
        return "City Bus " + getBusNumber() + " check: Brakes OK. " +
                (hasAirConditioning ? "AC functional." : "No AC unit.");
    }

    @Override
    public String toString() {
        return "CityBus{" +
                "id='" + getVehicleId() + "'" +
                ", busNumber='" + getBusNumber() + "'" +
                ", driver='" + getDriverName() + "'" +
                ", capacity=" + getCapacity() +
                ", AC=" + hasAirConditioning +
                ", seats=" + getBookedSeatCount() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
