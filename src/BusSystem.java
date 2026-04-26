import java.util.ArrayList;
import java.util.Scanner;

public class BusSystem {
    private static ArrayList<BusManager> buses = new ArrayList<BusManager>();
    private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private static ArrayList<Driver> drivers = new ArrayList<Driver>();
    private static ArrayList<Route> routes = new ArrayList<Route>();
    private static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private static ArrayList<Booking> bookings = new ArrayList<Booking>();
    private static ArrayList<Payment> payments = new ArrayList<Payment>();
    private static ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    private static ArrayList<Maintenance> maintenances = new ArrayList<Maintenance>();

    private static Scanner scanner = new Scanner(System.in);
    private static int busCounter = 1;
    private static int passengerCounter = 1;
    private static int driverCounter = 1;
    private static int routeCounter = 1;
    private static int ticketCounter = 1;
    private static int bookingCounter = 1;
    private static int paymentCounter = 1;
    private static int scheduleCounter = 1;
    private static int maintenanceCounter = 1;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    WELCOME TO BUS MANAGEMENT SYSTEM");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();
            System.out.println();

            if (choice.equals("1")) {
                addBus();
            } else if (choice.equals("2")) {
                addPassenger();
            } else if (choice.equals("3")) {
                addDriver();
            } else if (choice.equals("4")) {
                addRoute();
            } else if (choice.equals("5")) {
                bookTicket();
            } else if (choice.equals("6")) {
                cancelBooking();
            } else if (choice.equals("7")) {
                processPayment();
            } else if (choice.equals("8")) {
                trackBus();
            } else if (choice.equals("9")) {
                scheduleMaintenanceMenu();
            } else if (choice.equals("10")) {
                addSchedule();
            } else if (choice.equals("11")) {
                viewAllBuses();
            } else if (choice.equals("12")) {
                viewAllPassengers();
            } else if (choice.equals("13")) {
                viewAllBookings();
            } else if (choice.equals("14")) {
                viewAllRoutes();
            } else if (choice.equals("15")) {
                generateReports();
            } else if (choice.equals("16")) {
                busOperations();
            } else if (choice.equals("0")) {
                System.out.println("Thank you for using Bus Management System. Goodbye!");
                running = false;
            } else {
                System.out.println("Error: Invalid option '" + choice + "'. Enter a number from 0 to 16.");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n-------------- MAIN MENU --------------");
        System.out.println("  1.  Add Bus");
        System.out.println("  2.  Add Passenger");
        System.out.println("  3.  Add Driver");
        System.out.println("  4.  Add Route");
        System.out.println("  5.  Book Ticket");
        System.out.println("  6.  Cancel Booking");
        System.out.println("  7.  Process Payment");
        System.out.println("  8.  Track Bus");
        System.out.println("  9.  Schedule Maintenance");
        System.out.println(" 10.  Add Schedule");
        System.out.println(" 11.  View All Buses");
        System.out.println(" 12.  View All Passengers");
        System.out.println(" 13.  View All Bookings");
        System.out.println(" 14.  View All Routes");
        System.out.println(" 15.  Generate Reports");
        System.out.println(" 16.  Bus Operations");
        System.out.println("  0.  Exit");
        System.out.println("---------------------------------------");
        System.out.print("Enter choice: ");
    }

    //  ADD BUS
    private static void addBus() {
        System.out.println("--- Add New Bus ---");
        BusFactory.displayAvailableBusTypes();

        String busType = readValidBusType();

        String vehicleId = generateId("BUS", busCounter++);

        System.out.print("Enter bus name: ");
        String vehicleName = readNonEmpty("bus name");

        int capacity = readPositiveInt("Enter seating capacity: ");

        String fuelType;
        if (busType.equalsIgnoreCase("electric")) {
            fuelType = "Electric";
            System.out.println("Fuel type set to: Electric");
        } else {
            System.out.print("Enter fuel type (e.g., Diesel, Petrol): ");
            fuelType = readNonEmpty("fuel type");
        }

        System.out.print("Enter current location: ");
        String currentLocation = readNonEmpty("current location");

        System.out.print("Enter driver name: ");
        String driverName = readNonEmpty("driver name");

        String busNumber;
        while (true) {
            System.out.print("Enter bus number (e.g., KCA-001): ");
            busNumber = readNonEmpty("bus number");
            if (isBusNumberDuplicate(busNumber)) {
                System.out.println("Error: Bus number '" + busNumber + "' already exists. Enter a unique number.");
            } else {
                break;
            }
        }

        BusManager newBus = BusFactory.createBus(busType, vehicleId, vehicleName, capacity,
                fuelType, currentLocation, "Active", driverName, busNumber, "");
        buses.add(newBus);

        System.out.println("\nBus added successfully:");
        System.out.println(newBus.toString());
    }

    //  ADD PASSENGER
    private static void addPassenger() {
        System.out.println("--- Add New Passenger ---");

        String passengerId = generateId("PAS", passengerCounter++);

        System.out.print("Enter passenger name: ");
        String name = readNonEmpty("passenger name");

        String phone;
        while (true) {
            System.out.print("Enter phone number (10-15 digits): ");
            phone = scanner.nextLine().trim();
            if (InputValidator.isValidPhoneNumber(phone)) break;
        }

        String email;
        while (true) {
            System.out.print("Enter email address: ");
            email = scanner.nextLine().trim();
            if (InputValidator.isValidEmail(email)) break;
        }

        Passenger passenger = new Passenger(passengerId, name, phone, email);
        passengers.add(passenger);

        System.out.println("\nPassenger added successfully:");
        System.out.println(passenger.toString());
    }

    //  ADD DRIVER
    private static void addDriver() {
        System.out.println("--- Add New Driver ---");

        String driverId = generateId("DRV", driverCounter++);

        System.out.print("Enter driver name: ");
        String name = readNonEmpty("driver name");

        System.out.print("Enter license number: ");
        String licenseNumber = readNonEmpty("license number");

        int experience = readNonNegativeInt("Enter years of experience: ");

        Driver driver = new Driver(driverId, name, licenseNumber, experience);
        drivers.add(driver);

        System.out.println("\nDriver added successfully:");
        System.out.println(driver.toString());
    }

    //  ADD ROUTE
    private static void addRoute() {
        System.out.println("--- Add New Route ---");

        String routeId = generateId("RTE", routeCounter++);

        System.out.print("Enter start location: ");
        String startLocation = readNonEmpty("start location");

        System.out.print("Enter destination: ");
        String destination = readNonEmpty("destination");

        double distance = readPositiveDouble("Enter distance in km: ");

        System.out.print("Enter estimated travel time (e.g., 2h 30min): ");
        String estimatedTime = readNonEmpty("estimated time");

        Route route = new Route(routeId, startLocation, destination, distance, estimatedTime);
        routes.add(route);

        System.out.println("\nRoute added successfully:");
        System.out.println(route.toString());
    }

    //  BOOK TICKET
    private static void bookTicket() {
        System.out.println("--- Book Ticket ---");

        if (buses.isEmpty()) {
            System.out.println("No buses available. Please add a bus first (Option 1).");
            return;
        }
        if (passengers.isEmpty()) {
            System.out.println("No passengers registered. Please add a passenger first (Option 2).");
            return;
        }
        if (routes.isEmpty()) {
            System.out.println("No routes available. Please add a route first (Option 4).");
            return;
        }

        // Select passenger
        System.out.println("Registered Passengers:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println("  " + (i + 1) + ". [" + passengers.get(i).getPassengerId() + "] " +
                    passengers.get(i).getName());
        }
        int passengerIndex = readIntInRange("Select passenger number: ", 1, passengers.size()) - 1;
        Passenger selectedPassenger = passengers.get(passengerIndex);

        // Select bus
        System.out.println("Available Buses:");
        boolean anyAvailable = false;
        for (int i = 0; i < buses.size(); i++) {
            BusManager bus = buses.get(i);
            int free = bus.getCapacity() - bus.getBookedSeatCount();
            String availability = bus.checkAvailability() ? free + " seats free" : "UNAVAILABLE";
            System.out.println("  " + (i + 1) + ". [" + bus.getBusNumber() + "] " +
                    bus.getVehicleName() + " (" + availability + ")");
            if (bus.checkAvailability()) anyAvailable = true;
        }
        if (!anyAvailable) {
            System.out.println("All buses are full or unavailable.");
            return;
        }
        int busIndex = readIntInRange("Select bus number: ", 1, buses.size()) - 1;
        BusManager selectedBus = buses.get(busIndex);

        if (!selectedBus.checkAvailability()) {
            System.out.println("Error: The selected bus is not available or fully booked.");
            return;
        }

        // Select route
        System.out.println("Available Routes:");
        for (int i = 0; i < routes.size(); i++) {
            Route r = routes.get(i);
            System.out.println("  " + (i + 1) + ". [" + r.getRouteId() + "] " +
                    r.getStartLocation() + " -> " + r.getDestination() +
                    " (" + r.getDistance() + " km)");
        }
        int routeIndex = readIntInRange("Select route number: ", 1, routes.size()) - 1;
        Route selectedRoute = routes.get(routeIndex);

        // Select seat
        System.out.println("Bus capacity: " + selectedBus.getCapacity() + " seats.");
        System.out.println("Booked seats: " + selectedBus.getBookedSeats().toString());
        int seatNumber;
        while (true) {
            System.out.print("Enter seat number (1-" + selectedBus.getCapacity() + "): ");
            String seatInput = scanner.nextLine().trim();
            if (!InputValidator.isValidSeatNumber(seatInput, selectedBus.getCapacity())) continue;
            seatNumber = Integer.parseInt(seatInput.trim());
            if (selectedBus.isSeatBooked(seatNumber)) {
                System.out.println("Error: Seat " + seatNumber + " is already taken. Choose another.");
            } else {
                break;
            }
        }

        // Calculate fare and book
        double fare = selectedBus.calculateFare(selectedRoute.getDistance());
        System.out.println("Calculated fare: $" + String.format("%.2f", fare));

        boolean booked = selectedBus.bookSeat(seatNumber, selectedPassenger);
        if (!booked) {
            System.out.println("Booking failed. Please try again.");
            return;
        }

        String ticketId = generateId("TKT", ticketCounter++);
        Ticket ticket = new Ticket(ticketId, selectedPassenger, selectedBus, seatNumber, fare);
        tickets.add(ticket);

        String bookingId = generateId("BKG", bookingCounter++);
        Booking booking = new Booking(bookingId, selectedPassenger, ticket, "2026-04-20");
        bookings.add(booking);

        System.out.println("\n========== BOOKING CONFIRMATION ==========");
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Ticket ID  : " + ticketId);
        System.out.println("Passenger  : " + selectedPassenger.getName() +
                " (" + selectedPassenger.getPassengerId() + ")");
        System.out.println("Bus        : " + selectedBus.getBusNumber() +
                " - " + selectedBus.getVehicleName());
        System.out.println("Route      : " + selectedRoute.getStartLocation() +
                " -> " + selectedRoute.getDestination());
        System.out.println("Seat       : " + seatNumber);
        System.out.println("Fare       : $" + String.format("%.2f", fare));
        System.out.println("Status     : " + booking.getStatus());
        System.out.println("==========================================");
    }

    //  CANCEL BOOKING
    private static void cancelBooking() {
        System.out.println("--- Cancel Booking ---");

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("Confirmed Bookings:");
        boolean anyActive = false;
        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            if ("Confirmed".equals(b.getStatus())) {
                System.out.println("  " + (i + 1) + ". [" + b.getBookingId() + "] " +
                        b.getPassenger().getName() +
                        " | Seat: " + b.getTicket().getSeatNumber() +
                        " | Bus: " + b.getTicket().getBus().getBusNumber());
                anyActive = true;
            }
        }

        if (!anyActive) {
            System.out.println("No confirmed bookings to cancel.");
            return;
        }

        int index = readIntInRange("Enter booking number to cancel: ", 1, bookings.size()) - 1;
        Booking booking = bookings.get(index);

        if ("Cancelled".equals(booking.getStatus())) {
            System.out.println("Error: Booking " + booking.getBookingId() + " is already cancelled.");
            return;
        }

        booking.cancelBooking();
        BusManager bus = booking.getTicket().getBus();
        bus.releaseSeat(booking.getTicket().getSeatNumber());
        bus.cancelBooking(booking.getBookingId());
        System.out.println("Seat " + booking.getTicket().getSeatNumber() + " is now available again.");
    }

    //  PROCESS PAYMENT
    private static void processPayment() {
        System.out.println("--- Process Payment ---");

        if (bookings.isEmpty()) {
            System.out.println("No bookings found. Make a booking first (Option 5).");
            return;
        }

        System.out.println("Confirmed Bookings:");
        boolean anyConfirmed = false;
        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            if ("Confirmed".equals(b.getStatus())) {
                System.out.println("  " + (i + 1) + ". [" + b.getBookingId() + "] " +
                        b.getPassenger().getName() +
                        " | Fare: $" + String.format("%.2f", b.getTicket().getPrice()));
                anyConfirmed = true;
            }
        }

        if (!anyConfirmed) {
            System.out.println("No confirmed bookings available for payment.");
            return;
        }

        int index = readIntInRange("Select booking to pay: ", 1, bookings.size()) - 1;
        Booking booking = bookings.get(index);

        System.out.println("Payment methods: cash, card, mobile");
        String paymentMethod;
        while (true) {
            System.out.print("Enter payment method: ");
            paymentMethod = scanner.nextLine().trim();
            if (InputValidator.isValidPaymentMethod(paymentMethod)) break;
        }

        String paymentId = generateId("PAY", paymentCounter++);
        Payment payment = new Payment(paymentId, booking.getTicket().getPrice(), paymentMethod);
        boolean success = payment.processPayment();
        payments.add(payment);

        if (success) {
            System.out.println("\n========== PAYMENT RECEIPT ==========");
            System.out.println(payment.toString());
            System.out.println("======================================");
        }
    }

    //  TRACK BUS
    private static void trackBus() {
        System.out.println("--- Track Bus ---");

        if (buses.isEmpty()) {
            System.out.println("No buses in the system.");
            return;
        }

        System.out.println("Buses:");
        for (int i = 0; i < buses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + buses.get(i).getBusNumber() +
                    " - " + buses.get(i).getVehicleName());
        }

        int index = readIntInRange("Select bus to track: ", 1, buses.size()) - 1;
        BusManager bus = buses.get(index);

        System.out.println("\n" + bus.trackLocation());
        System.out.println("Status      : " + bus.getStatus());
        System.out.println("Seats Booked: " + bus.getBookedSeatCount() + "/" + bus.getCapacity());
        System.out.println("Route       : " + (bus.getRouteAssigned().isEmpty() ? "Not assigned" : bus.getRouteAssigned()));

        System.out.print("Update location? (yes/no): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("yes")) {
            System.out.print("Enter new location: ");
            String newLocation = readNonEmpty("new location");
            bus.updateLocation(newLocation);
        }
    }

    //  SCHEDULE MAINTENANCE
    private static void scheduleMaintenanceMenu() {
        System.out.println("--- Schedule Maintenance ---");

        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }

        System.out.println("Buses:");
        for (int i = 0; i < buses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + buses.get(i).getBusNumber());
        }

        int index = readIntInRange("Select bus: ", 1, buses.size()) - 1;
        BusManager bus = buses.get(index);

        System.out.print("Enter maintenance date (YYYY-MM-DD): ");
        String date = readNonEmpty("maintenance date");

        System.out.print("Enter maintenance description: ");
        String description = readNonEmpty("description");

        String maintenanceId = generateId("MNT", maintenanceCounter++);
        Maintenance maintenance = new Maintenance(maintenanceId, bus, date, description);
        maintenance.scheduleMaintenance();
        maintenances.add(maintenance);

        System.out.println(bus.performMaintenanceCheck());
    }

    //  ADD SCHEDULE
    private static void addSchedule() {
        System.out.println("--- Add Bus Schedule ---");

        if (buses.isEmpty()) {
            System.out.println("No buses available. Add a bus first (Option 1).");
            return;
        }
        if (routes.isEmpty()) {
            System.out.println("No routes available. Add a route first (Option 4).");
            return;
        }

        System.out.println("Buses:");
        for (int i = 0; i < buses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + buses.get(i).getBusNumber());
        }
        int busIndex = readIntInRange("Select bus: ", 1, buses.size()) - 1;
        BusManager bus = buses.get(busIndex);

        System.out.println("Routes:");
        for (int i = 0; i < routes.size(); i++) {
            Route r = routes.get(i);
            System.out.println("  " + (i + 1) + ". [" + r.getRouteId() + "] " +
                    r.getStartLocation() + " -> " + r.getDestination());
        }
        int routeIndex = readIntInRange("Select route: ", 1, routes.size()) - 1;
        Route route = routes.get(routeIndex);

        System.out.print("Enter departure time (e.g., 08:00 AM): ");
        String departure = readNonEmpty("departure time");

        System.out.print("Enter arrival time (e.g., 10:30 AM): ");
        String arrival = readNonEmpty("arrival time");

        String scheduleId = generateId("SCH", scheduleCounter++);
        Schedule schedule = new Schedule(scheduleId, bus, departure, arrival, route);
        schedules.add(schedule);
        bus.assignRoute(route.getRouteId());

        System.out.println("\nSchedule added successfully:");
        System.out.println(schedule.toString());
    }

    //  VIEW METHODS
    private static void viewAllBuses() {
        System.out.println("--- All Buses (" + buses.size() + ") ---");
        if (buses.isEmpty()) {
            System.out.println("  No buses registered.");
            return;
        }
        for (int i = 0; i < buses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + buses.get(i).toString());
        }
    }

    private static void viewAllPassengers() {
        System.out.println("--- All Passengers (" + passengers.size() + ") ---");
        if (passengers.isEmpty()) {
            System.out.println("  No passengers registered.");
            return;
        }
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + passengers.get(i).toString());
        }
    }

    private static void viewAllBookings() {
        System.out.println("--- All Bookings (" + bookings.size() + ") ---");
        if (bookings.isEmpty()) {
            System.out.println("  No bookings found.");
            return;
        }
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + bookings.get(i).toString());
        }
    }

    private static void viewAllRoutes() {
        System.out.println("--- All Routes (" + routes.size() + ") ---");
        if (routes.isEmpty()) {
            System.out.println("  No routes registered.");
            return;
        }
        for (int i = 0; i < routes.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + routes.get(i).toString());
        }
    }

    //  REPORTS
    private static void generateReports() {
        System.out.println("--- Generate Reports ---");
        System.out.println("  1. Daily Booking Report");
        System.out.println("  2. Revenue Report");
        System.out.println("  3. Bus Usage Report");
        System.out.println("  4. Passenger Statistics");
        System.out.println("  5. Full Report");
        System.out.print("Enter report type: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();
            ReportGenerator.generateDailyBookingReport(bookings, date);
        } else if (choice.equals("2")) {
            ReportGenerator.generateRevenueReport(payments);
        } else if (choice.equals("3")) {
            ReportGenerator.generateBusUsageReport(buses);
        } else if (choice.equals("4")) {
            ReportGenerator.generatePassengerReport(passengers, bookings);
        } else if (choice.equals("5")) {
            ReportGenerator.generateFullReport(buses, passengers, bookings, payments);
        } else {
            System.out.println("Error: Invalid report type.");
        }
    }

    //  BUS OPERATIONS
    private static void busOperations() {
        System.out.println("--- Bus Operations ---");

        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }

        System.out.println("Buses:");
        for (int i = 0; i < buses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + buses.get(i).getBusNumber() +
                    " [" + buses.get(i).getStatus() + "]");
        }

        int index = readIntInRange("Select bus: ", 1, buses.size()) - 1;
        BusManager bus = buses.get(index);

        System.out.println("  1. Start Bus");
        System.out.println("  2. Stop Bus");
        System.out.println("  3. View Vehicle Report");
        System.out.println("  4. Maintenance Check");
        System.out.print("Enter operation: ");
        String op = scanner.nextLine().trim();

        if (op.equals("1")) {
            bus.startVehicle();
        } else if (op.equals("2")) {
            bus.stopVehicle();
        } else if (op.equals("3")) {
            System.out.println(bus.generateVehicleReport());
        } else if (op.equals("4")) {
            System.out.println(bus.performMaintenanceCheck());
        } else {
            System.out.println("Error: Invalid operation.");
        }
    }

    //  UTILITY METHODS
    private static String generateId(String prefix, int counter) {
        return prefix + String.format("%03d", counter);
    }

    private static String readNonEmpty(String fieldName) {
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("Error: " + fieldName + " cannot be empty.");
            System.out.print("Enter " + fieldName + ": ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (InputValidator.isPositiveInteger(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    private static int readNonNegativeInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (InputValidator.isNonNegativeInteger(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (InputValidator.isPositiveDouble(input)) {
                return Double.parseDouble(input);
            }
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (InputValidator.isInRange(input, min, max)) {
                return Integer.parseInt(input);
            }
        }
    }

    private static String readValidBusType() {
        while (true) {
            System.out.print("Enter bus type (city/express/luxury/school/tourist/electric): ");
            String input = scanner.nextLine().trim();
            if (InputValidator.isValidBusType(input)) {
                return input.toLowerCase();
            }
        }
    }

    private static boolean isBusNumberDuplicate(String busNumber) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getBusNumber().equalsIgnoreCase(busNumber)) {
                return true;
            }
        }
        return false;
    }
}
