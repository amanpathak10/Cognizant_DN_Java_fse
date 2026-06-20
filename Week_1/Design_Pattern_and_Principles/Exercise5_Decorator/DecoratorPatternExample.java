public class DecoratorPatternExample {
    interface Notifier { void send(String msg); }
    static class EmailNotifier implements Notifier { public void send(String msg){ System.out.println("Email: "+msg); } }
    static abstract class NotifierDecorator implements Notifier {
        protected final Notifier wrappee; protected NotifierDecorator(Notifier n){ wrappee=n; }
        public void send(String msg){ wrappee.send(msg); }
    }
    static class SMSDecorator extends NotifierDecorator { SMSDecorator(Notifier n){ super(n); } public void send(String msg){ super.send(msg); System.out.println("SMS: "+msg); } }
    static class SlackDecorator extends NotifierDecorator { SlackDecorator(Notifier n){ super(n); } public void send(String msg){ super.send(msg); System.out.println("Slack: "+msg); } }

    public static void main(String[] args){
        Notifier n = new SlackDecorator(new SMSDecorator(new EmailNotifier()));
        n.send("Hello");
    }
}
