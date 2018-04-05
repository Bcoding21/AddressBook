import java.io.Serializable;
import java.util.Comparator;

public class BookEntry implements  Serializable {

    /**
     * Used to represent a person's information in an Address book
     * Comprised of a Contact class and an Address class. Supports
     * getter and setter operations.
     */
    private Contact contact;
    private Address address;

    public BookEntry(Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(contact.getFirstName()).append(" ")
                .append(contact.getLastName()).append("\n")
                .append(address.getStreetAddress()).append("\n")
                .append(address.getCity()).append(", ")
                .append(address.getState()).append(" ")
                .append(address.getZipCode());
        return builder.toString();
    }
}
