public class Route {
    private String routeId;
    private String startLocation;
    private String destination;
    private double distance;
    private String estimatedTime;

    public Route() {
        this.routeId = "";
        this.startLocation = "";
        this.destination = "";
        this.distance = 0.0;
        this.estimatedTime = "";
    }

    public Route(String routeId, String startLocation, String destination,
                 double distance, String estimatedTime) {
        this.routeId = routeId;
        this.startLocation = startLocation;
        this.destination = destination;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
    }

    public String getRouteId() { return routeId; }
    public String getStartLocation() { return startLocation; }
    public String getDestination() { return destination; }
    public double getDistance() { return distance; }
    public String getEstimatedTime() { return estimatedTime; }

    public void setRouteId(String routeId) { this.routeId = routeId; }
    public void setStartLocation(String startLocation) { this.startLocation = startLocation; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setDistance(double distance) { this.distance = distance; }
    public void setEstimatedTime(String estimatedTime) { this.estimatedTime = estimatedTime; }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + routeId + "'" +
                ", from='" + startLocation + "'" +
                ", to='" + destination + "'" +
                ", distance=" + distance + "km" +
                ", estimatedTime='" + estimatedTime + "'" +
                "}";
    }
}
