public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePayment(100.0);

        context.setStrategy(new PayPalPayment());
        context.executePayment(200.0);
    }
}
