import java.io.Serializable;
import java.util.Comparator;

public class Entry implements Comparable<Entry>, Serializable {

    /**
     * Used to represent a person's information in an Address book
     * Comprised of a Contact class and an Address class. Supports
     * getter and setter operations.
     */

    private Contact contact;
    private Address address;

    public Entry(Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public void changeAddress(String address) {
        this.address.setStreetAddress(address.toLowerCase());
    }

    public void changeCity(String city) {
        address.setCity(city.toLowerCase());
    }

    public void changeState(String state) {
        address.setState(state.toLowerCase());
    }

    public void changeZipCode(int zipCode) {
        address.setZipCode(zipCode);
    }

    public void changePhoneNumber(String phoneNumber) {
        contact.setPhoneNumber(phoneNumber);
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

    @Override
    public int compareTo(Entry o) {
        return contact.compareTo(o.contact);
    }

    public static class zipComparator implements Serializable, Comparator<Entry> {

        @Override
        public int compare(Entry entry1, Entry entry2) {

            int zip1 = entry1.getAddress().getZipCode();
            int zip2 = entry2.getAddress().getZipCode();
            int res = Integer.compare(zip1, zip2);

            if (res != 0) {
                return res;
            }

            res = entry1.getContact().compareTo(entry2.getContact());

            if (res != 0) {
                return res;
            }

            return entry1.getAddress().compareTo(entry2.getAddress());
        }

    }
    public static class lastNameComparator implements Serializable, Comparator<Entry> {

        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getContact().compareTo(o2.getContact());
        }
    }
}
