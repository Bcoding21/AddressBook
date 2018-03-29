import java.io.Serializable;
import java.util.Comparator;

public class Entry implements Serializable {

    private ContactData contactData;
    private AddressData addressData;

    public Entry(ContactData contactData, AddressData addressData) {
        this.contactData = contactData;
        this.addressData = addressData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public AddressData getAddressData() {
        return addressData;
    }

    public void changeAddress(String address) {
        this.addressData.setStreetAddress(address.toLowerCase());
    }

    public void changeCity(String city) {
        addressData.setCity(city.toLowerCase());
    }

    public void changeState(String state) {
        addressData.setState(state.toLowerCase());
    }

    public void changeZipCode(int zipCode) {
        addressData.setZipCode(zipCode);
    }

    public void changePhoneNumber(String phoneNumber) {
        contactData.setPhoneNumber(phoneNumber);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(contactData.getFirstName()).append(" ")
                .append(contactData.getLastName()).append("\n")
                .append(addressData.getStreetAddress()).append("\n")
                .append(addressData.getCity()).append(", ")
                .append(addressData.getState()).append(" ")
                .append(addressData.getZipCode());
        return builder.toString();
    }
    public static class zipComparator implements Serializable, Comparator<Entry> {

        @Override
        public int compare(Entry entry1, Entry entry2) {

            int zip1 = entry1.getAddressData().getZipCode();
            int zip2 = entry2.getAddressData().getZipCode();
            int res = Integer.compare(zip1, zip2);

            if (res != 0) {
                return res;
            }

            res = entry1.getContactData().compareTo(entry2.getContactData());

            if (res != 0) {
                return res;
            }

            return entry1.getAddressData().compareTo(entry2.getAddressData());
        }

    }
    public static class lastNameComparator implements Serializable, Comparator<Entry> {

        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getContactData().compareTo(o2.getContactData());
        }
    }
}
