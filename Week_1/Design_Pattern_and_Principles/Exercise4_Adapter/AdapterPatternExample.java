public class AdapterPatternExample {
    interface PaymentProcessor { void process(double amt); }
    // Adaptee
    static class StripeGateway { void makePayment(double a){ System.out.println("Stripe paid: "+a); } }
    // Adapter
    static class StripeAdapter implements PaymentProcessor {
        private final StripeGateway stripe = new StripeGateway();
        public void process(double amt){ stripe.makePayment(amt); }
    }

    public static void main(String[] args){
        PaymentProcessor p = new StripeAdapter();
        p.process(25.0);
    }
}
