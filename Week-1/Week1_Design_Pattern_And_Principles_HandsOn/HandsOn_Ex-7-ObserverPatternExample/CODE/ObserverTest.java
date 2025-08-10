public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setPrice("AAPL", 150.0);
        market.setPrice("GOOGL", 2800.0);
    }
}
