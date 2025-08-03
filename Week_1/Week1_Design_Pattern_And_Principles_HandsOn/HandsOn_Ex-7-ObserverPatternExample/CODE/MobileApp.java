public class MobileApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("MobileApp: " + stockSymbol + " price changed to " + price);
    }
}
