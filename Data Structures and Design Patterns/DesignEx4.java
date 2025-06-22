interface PaymentProcessor {
    void processPayment();
}

class PayPalGateway {
    void payViaPayPal() {
        System.out.println("Payment through PayPal");
    }
}

class PayPalAdapter implements PaymentProcessor {
    PayPalGateway gateway = new PayPalGateway();

    public void processPayment() {
        gateway.payViaPayPal();
    }
}

class DesignEx4 {
    public static void main(String[] args) {
        PaymentProcessor p = new PayPalAdapter();
        p.processPayment();
    }
}