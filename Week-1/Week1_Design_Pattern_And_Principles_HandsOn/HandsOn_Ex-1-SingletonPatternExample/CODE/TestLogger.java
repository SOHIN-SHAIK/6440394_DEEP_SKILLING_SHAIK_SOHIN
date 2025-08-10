public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.logMessage("First log message.");
        logger2.logMessage("Second log message.");

        if (logger1 == logger2) {
            System.out.println("Confirmed: Only one instance exists.");
        } else {
            System.out.println("Error: Multiple instances found!");
        }
    }
}
