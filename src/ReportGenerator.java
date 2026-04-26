import java.util.ArrayList;

public class ReportGenerator {

    public static void generateDailyBookingReport(ArrayList<Booking> bookings, String date) {
        System.out.println("\n========== DAILY BOOKING REPORT ==========");
        System.out.println("Date: " + date);
        System.out.println("------------------------------------------");
        int count = 0;
        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            if (b.getBookingDate().equals(date)) {
                System.out.println("  " + b.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("  No bookings found for " + date + ".");
        } else {
            System.out.println("Total Bookings: " + count);
        }
        System.out.println("==========================================\n");
    }

    public static void generateRevenueReport(ArrayList<Payment> payments) {
        System.out.println("\n========== REVENUE REPORT ==========");
        double totalRevenue = 0.0;
        int completed = 0;
        int failed = 0;
        for (int i = 0; i < payments.size(); i++) {
            Payment p = payments.get(i);
            if ("Completed".equals(p.getPaymentStatus())) {
                totalRevenue += p.getAmount();
                completed++;
            } else {
                failed++;
            }
        }
        System.out.println("Total Payments Processed : " + completed);
        System.out.println("Failed Payments          : " + failed);
        System.out.println("Total Revenue Collected  : $" + String.format("%.2f", totalRevenue));
        System.out.println("=====================================\n");
    }

    public static void generateBusUsageReport(ArrayList<BusManager> buses) {
        System.out.println("\n========== BUS USAGE REPORT ==========");
        if (buses.isEmpty()) {
            System.out.println("  No buses registered.");
        }
        for (int i = 0; i < buses.size(); i++) {
            BusManager bus = buses.get(i);
            int booked = bus.getBookedSeatCount();
            int capacity = bus.getCapacity();
            double utilization = capacity > 0 ? (double) booked / capacity * 100 : 0;
            System.out.println("  Bus " + bus.getBusNumber() +
                    " | Booked: " + booked + "/" + capacity +
                    " | Utilization: " + String.format("%.1f", utilization) + "%" +
                    " | Status: " + bus.getStatus());
        }
        System.out.println("======================================\n");
    }

    public static void generatePassengerReport(ArrayList<Passenger> passengers,
                                               ArrayList<Booking> bookings) {
        System.out.println("\n========== PASSENGER STATISTICS REPORT ==========");
        System.out.println("Total Registered Passengers: " + passengers.size());
        System.out.println("Total Bookings Made        : " + bookings.size());
        int confirmed = 0;
        int cancelled = 0;
        for (int i = 0; i < bookings.size(); i++) {
            String status = bookings.get(i).getStatus();
            if ("Confirmed".equals(status)) {
                confirmed++;
            } else if ("Cancelled".equals(status)) {
                cancelled++;
            }
        }
        System.out.println("Confirmed Bookings         : " + confirmed);
        System.out.println("Cancelled Bookings         : " + cancelled);
        System.out.println("=================================================\n");
    }

    public static void generateFullReport(ArrayList<BusManager> buses,
                                          ArrayList<Passenger> passengers,
                                          ArrayList<Booking> bookings,
                                          ArrayList<Payment> payments) {
        System.out.println("\n==========================================");
        System.out.println("   BUS MANAGEMENT SYSTEM - FULL REPORT");
        System.out.println("==========================================");
        generateBusUsageReport(buses);
        generatePassengerReport(passengers, bookings);
        generateRevenueReport(payments);
    }
}
