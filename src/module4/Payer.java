package module4;

public class Payer {
    String surname;
    String name;
    String address;
    String cardNumber;

    public Payer(String surname, String name, String address, String cardNumber) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.cardNumber = cardNumber;
    }

    public String toString() {
        return String.format("Payer: %s %s, address: %s, card: %s", surname, name, address, cardNumber);
    }
}
