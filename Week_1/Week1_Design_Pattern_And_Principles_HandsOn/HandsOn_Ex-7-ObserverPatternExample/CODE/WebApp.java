public class WebApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("WebApp: " + stockSymbol + " price changed to " + price);
    }
}
