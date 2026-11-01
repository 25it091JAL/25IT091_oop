
interface Notifier {

    void send(String message);
}

interface Urgent {
}

class EmailUrgent implements Notifier, Urgent {

    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

public class NotificationSenders {

    public static void main(String[] args) {
        Notifier email = message -> System.out.println("Email: " + message);
        Notifier sms = message -> System.out.println("SMS: " + message);
        Notifier[] senders = {email, sms};
        String message = "Hello! This is a notification.";
        for (Notifier sender : senders) {
            sender.send(message);
        }
        Notifier urgentEmail = new EmailUrgent();
        if (urgentEmail instanceof Urgent) {
            urgentEmail.send(message);
            urgentEmail.send(message);
        }
    }
}
