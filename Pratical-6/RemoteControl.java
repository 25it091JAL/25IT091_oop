
interface Switchable {

    void on();

    void off();

    default void toggle() {
        on();
        off();
    }
}

class Fan implements Switchable {

    public void on() {
        System.out.println("Fan ON");
    }

    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {

    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }
}

@FunctionalInterface
interface Permission {

    boolean canSwitchOn(Switchable device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {
        Switchable[] devices = {new Fan(), new Light()

        };
        for (Switchable device : devices) {
            device.toggle();
        }

        Permission rule1 = new Permission() {
            public boolean canSwitchOn(Switchable device, int hour) {
                return hour < 12;
            }
        };
        Permission rule2 = (device, hour) -> hour >= 8 && hour <= 20;
        System.out.println(rule1.canSwitchOn(new Fan(), 10));
        System.out.println(rule2.canSwitchOn(new Light(), 10));
    }
}
