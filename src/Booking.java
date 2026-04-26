public class Booking {
        private String bookingId;
        private Passenger passenger;
        private Ticket ticket;
        private String bookingDate;
        private String status;

        public Booking() {
            this.bookingId = "";
            this.passenger = null;
            this.ticket = null;
            this.bookingDate = "";
            this.status = "Pending";
        }

        public Booking(String bookingId, Passenger passenger, Ticket ticket, String bookingDate) {
            this.bookingId = bookingId;
            this.passenger = passenger;
            this.ticket = ticket;
            this.bookingDate = bookingDate;
            this.status = "Confirmed";
        }

        public String getBookingId() { return bookingId; }
        public Passenger getPassenger() { return passenger; }
        public Ticket getTicket() { return ticket; }
        public String getBookingDate() { return bookingDate; }
        public String getStatus() { return status; }

        public void setBookingId(String bookingId) { this.bookingId = bookingId; }
        public void setPassenger(Passenger passenger) { this.passenger = passenger; }
        public void setTicket(Ticket ticket) { this.ticket = ticket; }
        public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
        public void setStatus(String status) { this.status = status; }

        public boolean confirmBooking() {
            this.status = "Confirmed";
            System.out.println("Booking " + bookingId + " confirmed successfully.");
            return true;
        }

        public boolean cancelBooking() {
            this.status = "Cancelled";
            System.out.println("Booking " + bookingId + " has been cancelled.");
            return true;
        }

        @Override
        public String toString() {
            return "Booking{" +
                    "id='" + bookingId + "'" +
                    ", passenger='" + (passenger != null ? passenger.getName() : "N/A") + "'" +
                    ", ticket='" + (ticket != null ? ticket.getTicketId() : "N/A") + "'" +
                    ", date='" + bookingDate + "'" +
                    ", status='" + status + "'" +
                    "}";
        }
    }

