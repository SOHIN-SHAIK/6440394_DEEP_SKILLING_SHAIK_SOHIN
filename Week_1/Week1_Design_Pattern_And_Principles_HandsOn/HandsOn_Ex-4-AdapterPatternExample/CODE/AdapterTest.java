public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(120.0);

        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(75.5);
    }
}
