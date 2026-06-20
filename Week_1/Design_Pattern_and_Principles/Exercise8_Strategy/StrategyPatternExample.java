public class StrategyPatternExample {
    interface PaymentStrategy { void pay(double amt); }
    static class CreditCardPayment implements PaymentStrategy { public void pay(double amt){ System.out.println("Paid by card: "+amt); } }
    static class PayPalPayment implements PaymentStrategy { public void pay(double amt){ System.out.println("Paid by PayPal: "+amt); } }
    static class PaymentContext {
        private PaymentStrategy strategy;
        public void setStrategy(PaymentStrategy s){ strategy=s; }
        public void pay(double amt){ strategy.pay(amt); }
    }
    public static void main(String[] args){
        PaymentContext ctx = new PaymentContext();
        ctx.setStrategy(new CreditCardPayment()); ctx.pay(50);
        ctx.setStrategy(new PayPalPayment()); ctx.pay(75);
    }
}
