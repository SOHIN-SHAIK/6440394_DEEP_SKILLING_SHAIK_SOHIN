public class DecoratorTest {
    public static void main(String[] args) {
        // Base notifier is Email
        Notifier notifier = new EmailNotifier();

        // Decorate with SMS, then Slack
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("System is up!");
    }
}
