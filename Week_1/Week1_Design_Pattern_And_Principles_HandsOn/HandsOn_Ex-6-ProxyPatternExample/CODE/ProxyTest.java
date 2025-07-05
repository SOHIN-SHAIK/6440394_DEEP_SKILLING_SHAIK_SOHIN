public class ProxyTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo1.jpg");

        img.display(); // Loads and displays
        img.display(); // Cached: displays only
    }
}
