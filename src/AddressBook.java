import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {
    /**
     * Represents an Address Book as a Tree Map. The key is a
     * concatenation of fields. The value is a pair of classes,
     * Contact and Address, that represent a person's information.
     * Can order entries by name or zip code and insert or remove
     * entries and other operations.
     */

    private String bookName;
    private String filePath;
    private Map<String, Pair<Contact, Address>> entries;

    /**
     * Generates key to order entries by zip code
     * @param entry Represents a persons's information
     * @return String that is the concatenation
     * of the entry's zipCode, last name, and first
     * name in that order
     */
    private String getZipBasedKey(Pair<Contact, Address> entry){
        int zip = entry.getValue().getZipCode();
        String firstName = entry.getKey().getFirstName();
        String lastName = entry.getKey().getLastName();
        return Integer.toString(zip) + lastName + firstName;
    }

    private String getLastNameBasedKey(Pair<Contact, Address> entry){
        String firstName = entry.getKey().getFirstName();
        String lastName = entry.getKey().getLastName();
        return lastName + firstName;
    }

    public AddressBook(){
        bookName = "";
        filePath = "";
        entries = new TreeMap();
    }

    public void setBookName(String name){ bookName = name; }

    public void add(Contact contact, Address address){
        if (contact != null && address != null){
            Pair<Contact, Address> entry = new Pair<>(contact, address);
            String entryKey = getLastNameBasedKey(entry);
            entries.put(entryKey, entry);
        }
    }

    public void remove(String key) { entries.remove(key); }

    public void orderByZip () {
        Map<String, Pair<Contact, Address>> zipOrdered = new TreeMap<>();

        entries.forEach((String key, Pair<Contact, Address> entry)
                -> zipOrdered.put(getZipBasedKey(entry), entry));

        entries = zipOrdered;
    }

    public void orderByLastName(){
        Map<String, Pair<Contact, Address>> lastNameSorted = new TreeMap<>();

       entries.forEach((String key, Pair<Contact, Address> entry) ->
               lastNameSorted.put(getLastNameBasedKey(entry), entry));

       entries = lastNameSorted;
    }

    public void printAllEntries() {

    }
}
