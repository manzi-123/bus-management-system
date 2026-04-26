public class ElectricBus extends BusManager {
    private int batteryCapacity;
    private int currentChargeLevel;

    public ElectricBus() {
        super();
        this.batteryCapacity = 200;
        this.currentChargeLevel = 100;
    }

    public ElectricBus(String vehicleId, String vehicleName, int capacity, String fuelType,
                       String currentLocation, String status, String driverName,
                       String busNumber, String routeAssigned, int batteryCapacity) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status,
                driverName, busNumber, routeAssigned);
        this.batteryCapacity = batteryCapacity;
        this.currentChargeLevel = 100;
    }

    public int getBatteryCapacity() { return batteryCapacity; }
    public int getCurrentChargeLevel() { return currentChargeLevel; }
    public void setBatteryCapacity(int batteryCapacity) { this.batteryCapacity = batteryCapacity; }
    public void setCurrentChargeLevel(int currentChargeLevel) { this.currentChargeLevel = currentChargeLevel; }

    @Override
    public void startVehicle() {
        if (currentChargeLevel < 10) {
            System.out.println("Error: Electric Bus " + getBusNumber() +
                    " cannot start. Battery too low (" + currentChargeLevel + "%).");
            return;
        }
        setStatus("Active");
        System.out.println("Electric Bus " + getBusNumber() +
                " started silently. Battery: " + currentChargeLevel + "%");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.15;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.35;
    }

    @Override
    public String performMaintenanceCheck() {
        return "Electric Bus " + getBusNumber() + " check: Battery at " + currentChargeLevel +
                "%. Capacity: " + batteryCapacity + " kWh.";
    }

    @Override
    public String toString() {
        return "ElectricBus{" +
                "id='" + getVehicleId() + "'" +
                ", busNumber='" + getBusNumber() + "'" +
                ", driver='" + getDriverName() + "'" +
                ", battery=" + batteryCapacity + "kWh" +
                ", charge=" + currentChargeLevel + "%" +
                ", seats=" + getBookedSeatCount() + "/" + getCapacity() +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
