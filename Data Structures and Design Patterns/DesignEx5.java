interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Email sent");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send() {
        notifier.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("SMS sent");
    }
}

class DesignEx5 {
    public static void main(String[] args) {
        Notifier n = new SMSNotifierDecorator(new EmailNotifier());
        n.send();
    }
}