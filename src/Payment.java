public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment() {
        this.paymentId = "";
        this.amount = 0.0;
        this.paymentMethod = "";
        this.paymentStatus = "Pending";
    }

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Pending";
    }

    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }

    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public boolean processPayment() {
        if (amount <= 0) {
            System.out.println("Error: Invalid payment amount: $" + amount);
            this.paymentStatus = "Failed";
            return false;
        }
        this.paymentStatus = "Completed";
        System.out.println("Payment " + paymentId + " of $" + String.format("%.2f", amount) +
                " processed via " + paymentMethod + ".");
        return true;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + paymentId + "'" +
                ", amount=$" + String.format("%.2f", amount) +
                ", method='" + paymentMethod + "'" +
                ", status='" + paymentStatus + "'" +
                "}";
    }
}
