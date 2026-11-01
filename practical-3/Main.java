import java.util.Objects;

class Customer implements Cloneable {
    private String name;
    private String email;
    private String mobile;
    private final String customerId;
    private Address address;

    private static long customerCounter = 100;

    private static String generateCustomerId() {
        return "CUST" + (++customerCounter);
    }

    public static class Address {
        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }

    public Customer(String name, String email, String mobile, Address address) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.customerId = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public Customer clone() {
        try {
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static int accountCounter = 0;

    private static String generateAccountNumber() {
        return String.format("AC%04d", ++accountCounter);
    }

    public Account(String ownerName, long openingBalance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = Math.max(0, openingBalance);
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        if (amount > 0 && active) {
            balance += amount;
        }
    }

    public boolean withdraw(long amount) {
        if (amount <= 0 || !active || balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public String getStatement() {
        return "Account Number: " + accountNumber
                + "\nOwner: " + ownerName
                + "\nBalance: Rs. " + balance
                + "\nActive: " + active;
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | "
                + balance + " | Active: " + active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Account)) {
            return false;
        }

        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        Account a1 = new Account("Riya", 4000);
        a1.deposit(500);

        Account a2 = new Account("Amit", 2000);

        System.out.println("Account Details:");
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("a1 equals a2: " + a1.equals(a2));
        System.out.println("a1 instanceof Account: " + (a1 instanceof Account));

        Customer.Address address =
                new Customer.Address("Station Road", "Navsari", "396445");

        Customer customer =
                new Customer("Riya", "riya@gmail.com", "9876543210", address);

        Customer copy = customer.clone();

        System.out.println("\nCustomer ID: " + customer.getCustomerId());
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("City: " + customer.getAddress().getCity());
        System.out.println("Customer cloned: " + (copy instanceof Customer));

        System.out.println("\nAccount Statement:");
        System.out.println(a1.getStatement());
    }
}