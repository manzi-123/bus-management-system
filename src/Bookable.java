public interface Bookable {
        boolean bookSeat(int seatNumber, Passenger passenger);
        boolean cancelBooking(String bookingId);
        double calculateFare(double distance);
    }