
abstract class Media {

    String title;
    int daysLate;

    Media(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double lateFee();
}

class Book extends Media {

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double lateFee() {
        return daysLate * 2;
    }
}

class DVD extends Media {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double lateFee() {
        return daysLate * 5;
    }
}

class Magazine extends Media {

    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double lateFee() {
        return daysLate * 3;
    }
}

public class MediaDemo {

    public static void main(String[] args) {

        Media[] items = {
            new Book("Java Book", 3),
            new DVD("Movie DVD", 2),
            new Magazine("Tech Magazine", 4)
        };

        double total = 0;

        for (Media m : items) {

            double fee = m.lateFee();

            System.out.println(m.title + " Late Fee = " + fee);

            total = total + fee;
        }

        System.out.println("Total Late Fee = " + total);
    }
}
