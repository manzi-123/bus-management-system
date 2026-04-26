public abstract class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private int capacity;
    private String fuelType;
    private String currentLocation;
    private String status;

    public Vehicle() {
        this.vehicleId = "";
        this.vehicleName = "";
        this.capacity = 0;
        this.fuelType = "";
        this.currentLocation = "Unknown";
        this.status = "Inactive";
    }

    public Vehicle(String vehicleId, String vehicleName, int capacity, String fuelType,
                   String currentLocation, String status) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.currentLocation = currentLocation;
        this.status = status;
    }

    public String getVehicleId() { return vehicleId; }
    public String getVehicleName() { return vehicleName; }
    public int getCapacity() { return capacity; }
    public String getFuelType() { return fuelType; }
    public String getCurrentLocation() { return currentLocation; }
    public String getStatus() { return status; }

    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + "'" +
                ", vehicleName='" + vehicleName + "'" +
                ", capacity=" + capacity +
                ", fuelType='" + fuelType + "'" +
                ", currentLocation='" + currentLocation + "'" +
                ", status='" + status + "'" +
                "}";
    }

    public abstract void startVehicle();
    public abstract void stopVehicle();
    public abstract double calculateFuelConsumption(double distance);
    public abstract boolean checkAvailability();
    public abstract void assignRoute(String routeId);
    public abstract void updateLocation(String location);
    public abstract String performMaintenanceCheck();
    public abstract String generateVehicleReport();
}