public class BusFactory {

        public static BusManager createBus(String busType, String vehicleId, String vehicleName,
                                           int capacity, String fuelType, String currentLocation,
                                           String status, String driverName, String busNumber,
                                           String routeAssigned) {
            String type = busType.trim().toLowerCase();

            if (type.equals("city")) {
                return new CityBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, true);
            } else if (type.equals("express")) {
                return new ExpressBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, 5.0);
            } else if (type.equals("luxury")) {
                return new LuxuryBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, true, true);
            } else if (type.equals("school")) {
                return new SchoolBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, "General School");
            } else if (type.equals("tourist")) {
                return new TouristBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, "Standard");
            } else if (type.equals("electric")) {
                return new ElectricBus(vehicleId, vehicleName, capacity, "Electric", currentLocation,
                        status, driverName, busNumber, routeAssigned, 200);
            } else {
                System.out.println("Unknown bus type '" + busType + "'. Defaulting to CityBus.");
                return new CityBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, false);
            }
        }

        public static void displayAvailableBusTypes() {
            System.out.println("  Available Bus Types:");
            System.out.println("    city     - Standard city bus (optional AC)");
            System.out.println("    express  - Express bus with additional express fee");
            System.out.println("    luxury   - Luxury bus with WiFi and reclining seats");
            System.out.println("    school   - School bus with subsidized fares");
            System.out.println("    tourist  - Tourist bus with tour packages");
            System.out.println("    electric - Electric bus with battery system");
        }
    }

