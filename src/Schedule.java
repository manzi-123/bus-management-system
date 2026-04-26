public class Schedule {
    private String scheduleId;
    private BusManager bus;
    private String departureTime;
    private String arrivalTime;
    private Route route;

    public Schedule() {
        this.scheduleId = "";
        this.bus = null;
        this.departureTime = "";
        this.arrivalTime = "";
        this.route = null;
    }

    public Schedule(String scheduleId, BusManager bus, String departureTime,
                    String arrivalTime, Route route) {
        this.scheduleId = scheduleId;
        this.bus = bus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = route;
    }

    public String getScheduleId() { return scheduleId; }
    public BusManager getBus() { return bus; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public Route getRoute() { return route; }

    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }
    public void setBus(BusManager bus) { this.bus = bus; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setRoute(Route route) { this.route = route; }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + scheduleId + "'" +
                ", bus='" + (bus != null ? bus.getBusNumber() : "N/A") + "'" +
                ", departure='" + departureTime + "'" +
                ", arrival='" + arrivalTime + "'" +
                ", route='" + (route != null ? route.getRouteId() : "N/A") + "'" +
                "}";
    }
}
