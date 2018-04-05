import java.awt.print.Book;
import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {
    /**
     * Used to represent an address book with entries
     * stored as a treeSet. Supports basic operations
     * operations such as add, remove, and sorting by
     * certain values. Sorts entries by last name initially.
     */

    public enum Order {LAST_NAME, ZIP};
    private Map<String, BookEntry> entries;
    private Order order;

    public AddressBook(){
        entries = new TreeMap<>();
        order = Order.LAST_NAME;
    }

    public AddressBook(AddressBook addressBook){
        entries = new TreeMap<>(addressBook.entries);
        order = Order.LAST_NAME;
    }

    public void add(BookEntry bookEntry){
        if (bookEntry != null){
            String key = getKey(bookEntry);
            if (!entries.containsKey(key)){
                entries.put(key, bookEntry);
            }
        }
    }

    public BookEntry remove(String key) {
        return entries.remove(key.toLowerCase());
    }

    void orderByZip(){
        Map<String, BookEntry> zipSorted = new TreeMap<>();
        order = Order.ZIP;
        entries.forEach((String key, BookEntry bookEntry)
                -> zipSorted.put(getKey(bookEntry), bookEntry));
        entries = zipSorted;
    }

    void orderByLastName(){
        Map<String, BookEntry> lastNameSorted = new TreeMap<>();
        entries.forEach((String key, BookEntry bookEntry)
                -> lastNameSorted.put(getKey(bookEntry), bookEntry));
        entries = lastNameSorted;
    }

    public void changePhoneNumber(String key, String number){
        entries.get(key).getContact().setPhoneNumber(number);
    }

    public void changeStreetAddress(String key, String address){
        entries.get(key).getAddress().setStreetAddress(address);
    }

    public void changeCity(String key, String city) {
        entries.get(key).getAddress().setCity(city);
    }

    public void changeState(String key, String state){
        entries.get(key).getAddress().setState(state);
    }

    public void changeZip(String key, int zipCode) {
        BookEntry bookEntry = remove(key);
        bookEntry.getAddress().setZipCode(zipCode);
        String newKey = getKey(bookEntry);
        entries.put(newKey, bookEntry);
    }

    public void printAllEntries() {}

    public Map<String, BookEntry> getEntries() {
        return entries;
    }

    private String getKey(BookEntry bookEntry){

        switch (order){

            case LAST_NAME: {
                return bookEntry.getContact().getLastName() +
                        bookEntry.getContact().getFirstName();
            }

            case ZIP:
                return bookEntry.getAddress().getZipCode() +
                        bookEntry.getContact().getLastName() +
                        bookEntry.getContact().getFirstName();

                default:
                    return "";
        }
    }
}
