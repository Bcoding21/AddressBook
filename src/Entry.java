import java.io.Serializable;
import java.util.Comparator;

public class Entry implements Serializable {

    private Contact contact;
    private Location location;

    public Entry(Contact contact, Location location) {
        this.contact = contact;
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public Location getLocation() {
        return location;
    }

    public void changeAddress(String address) {
        location.setAddress(address.toLowerCase());
    }

    public void changeCity(String city) {
        location.setCity(city.toLowerCase());
    }

    public void changeState(String state) {
        location.setState(state.toLowerCase());
    }

    public void changeZipCode(short zipCode) {
        location.setZipCode(zipCode);
    }

    public void changePhoneNumber(String phoneNumber) {
        contact.setPhoneNumber(phoneNumber);
    }

   public static class ZipCodeComparator implements Comparator<Entry> {

        @Override
        public int compare(Entry o1, Entry o2) {

            short zip1 = o1.getLocation().getZipCode();
            short zip2 = o2.getLocation().getZipCode();
            int res = Short.compare(zip1, zip2);

            if (res == 0) {
                return res;
            }

            String first = o1.getContact().getLastName() + o1.getContact().getFirstName();
            String second = o2.getContact().getLastName() + o2.getContact().getFirstName();

            return first.compareTo(second);
        }

    }

   public static class NameComparator implements Comparator<Entry> {

        @Override
        public int compare(Entry o1, Entry o2) {
            String first = o1.getContact().getLastName() + o1.getContact().getFirstName();
            String second = o2.getContact().getLastName() + o2.getContact().getFirstName();
            return first.compareTo(second);
        }
    }

}
