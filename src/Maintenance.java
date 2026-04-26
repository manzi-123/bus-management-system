public class Maintenance {
    private String maintenanceId;
    private Vehicle vehicle;
    private String maintenanceDate;
    private String description;

    public Maintenance() {
        this.maintenanceId = "";
        this.vehicle = null;
        this.maintenanceDate = "";
        this.description = "";
    }

    public Maintenance(String maintenanceId, Vehicle vehicle,
                       String maintenanceDate, String description) {
        this.maintenanceId = maintenanceId;
        this.vehicle = vehicle;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
    }

    public String getMaintenanceId() { return maintenanceId; }
    public Vehicle getVehicle() { return vehicle; }
    public String getMaintenanceDate() { return maintenanceDate; }
    public String getDescription() { return description; }

    public void setMaintenanceId(String maintenanceId) { this.maintenanceId = maintenanceId; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setMaintenanceDate(String maintenanceDate) { this.maintenanceDate = maintenanceDate; }
    public void setDescription(String description) { this.description = description; }

    public void scheduleMaintenance() {
        System.out.println("=== Maintenance Scheduled ===");
        System.out.println("ID         : " + maintenanceId);
        System.out.println("Vehicle    : " + (vehicle != null ? vehicle.getVehicleId() : "N/A"));
        System.out.println("Date       : " + maintenanceDate);
        System.out.println("Description: " + description);
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id='" + maintenanceId + "'" +
                ", vehicle='" + (vehicle != null ? vehicle.getVehicleId() : "N/A") + "'" +
                ", date='" + maintenanceDate + "'" +
                ", description='" + description + "'" +
                "}";
    }
}
