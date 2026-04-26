public class InputValidator {

    public static boolean isNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty.");
            return false;
        }
        return true;
    }

    public static boolean isValidInteger(String input) {
        if (!isNotEmpty(input)) return false;
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + input.trim() + "' is not a valid whole number.");
            return false;
        }
    }

    public static boolean isValidDouble(String input) {
        if (!isNotEmpty(input)) return false;
        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + input.trim() + "' is not a valid number.");
            return false;
        }
    }

    public static boolean isPositiveInteger(String input) {
        if (!isValidInteger(input)) return false;
        int value = Integer.parseInt(input.trim());
        if (value <= 0) {
            System.out.println("Error: Value must be greater than zero. Got: " + value);
            return false;
        }
        return true;
    }

    public static boolean isPositiveDouble(String input) {
        if (!isValidDouble(input)) return false;
        double value = Double.parseDouble(input.trim());
        if (value <= 0) {
            System.out.println("Error: Value must be greater than zero. Got: " + value);
            return false;
        }
        return true;
    }

    public static boolean isNonNegativeInteger(String input) {
        if (!isValidInteger(input)) return false;
        int value = Integer.parseInt(input.trim());
        if (value < 0) {
            System.out.println("Error: Value cannot be negative. Got: " + value);
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phone) {
        if (!isNotEmpty(phone)) return false;
        String cleaned = phone.trim();
        if (!cleaned.matches("^\\+?[0-9]{10,15}$")) {
            System.out.println("Error: '" + cleaned + "' is not a valid phone number. " +
                    "Must be 10-15 digits, optionally starting with '+'.");
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (!isNotEmpty(email)) return false;
        if (!email.trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Error: '" + email.trim() + "' is not a valid email address.");
            return false;
        }
        return true;
    }

    public static boolean isValidBusType(String busType) {
        if (!isNotEmpty(busType)) return false;
        String type = busType.trim().toLowerCase();
        if (!type.equals("city") && !type.equals("express") && !type.equals("luxury") &&
                !type.equals("school") && !type.equals("tourist") && !type.equals("electric")) {
            System.out.println("Error: '" + busType.trim() +
                    "' is not a valid bus type. Choose: city, express, luxury, school, tourist, electric.");
            return false;
        }
        return true;
    }

    public static boolean isValidSeatNumber(String input, int capacity) {
        if (!isValidInteger(input)) return false;
        int seat = Integer.parseInt(input.trim());
        if (seat < 1 || seat > capacity) {
            System.out.println("Error: Seat number must be between 1 and " + capacity + ". Got: " + seat);
            return false;
        }
        return true;
    }

    public static boolean isValidPaymentMethod(String method) {
        if (!isNotEmpty(method)) return false;
        String m = method.trim().toLowerCase();
        if (!m.equals("cash") && !m.equals("card") && !m.equals("mobile")) {
            System.out.println("Error: '" + method.trim() +
                    "' is not valid. Choose: cash, card, or mobile.");
            return false;
        }
        return true;
    }

    public static boolean isInRange(String input, int min, int max) {
        if (!isValidInteger(input)) return false;
        int value = Integer.parseInt(input.trim());
        if (value < min || value > max) {
            System.out.println("Error: Please enter a number between " + min + " and " + max + ".");
            return false;
        }
        return true;
    }
}
