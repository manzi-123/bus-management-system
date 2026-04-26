public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private int experienceYears;

    public Driver() {
        this.driverId = "";
        this.name = "";
        this.licenseNumber = "";
        this.experienceYears = 0;
    }

    public Driver(String driverId, String name, String licenseNumber, int experienceYears) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getDriverId() { return driverId; }
    public String getName() { return name; }
    public String getLicenseNumber() { return licenseNumber; }
    public int getExperienceYears() { return experienceYears; }

    public void setDriverId(String driverId) { this.driverId = driverId; }
    public void setName(String name) { this.name = name; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + driverId + "'" +
                ", name='" + name + "'" +
                ", license='" + licenseNumber + "'" +
                ", experience=" + experienceYears + " years" +
                "}";
    }
}
