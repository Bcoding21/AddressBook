import java.io.Serializable;

public class Entry implements Serializable {

    /**
     * Represents the data that an Address book contains.
     * Is composed of Contact Data class and Address Data
     * class. Supports operations to set and get fields
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
}
