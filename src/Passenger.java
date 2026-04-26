public class Passenger {
    private String passengerId;
    private String name;
    private String phoneNumber;
    private String email;

    public Passenger() {
        this.passengerId = "";
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
    }

    public Passenger(String passengerId, String name, String phoneNumber, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + passengerId + "'" +
                ", name='" + name + "'" +
                ", phone='" + phoneNumber + "'" +
                ", email='" + email + "'" +
                "}";
    }
}
