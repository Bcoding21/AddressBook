import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {

    /**
     * Represents an Address Book. Uses a concatenation of fields
     * as a key and entrys as the value. Can order entrys by
     * name or zipCode and insert or remove entrys and
     * other operations
     */

    private String bookName;
    private String filePath;
    private Map<String, Entry> entries;

    /**
     * Gets key based on zip code
     * @param entry Represents a persons's information
     * @return String that is the combination
     * of the entry's zipCode, last name, and first
     * name in that order
     */
    private String getZipBasedKey(Entry entry){
        int zip = entry.getAddress().getZipCode();
        String firstName = entry.getContact().getFirstName();
        String lastName = entry.getContact().getLastName();
        return Integer.toString(zip) + lastName + firstName;
    }

    /**
     * Gets key based on last name
     * @param entry Represent person's information
     * @return String composed of last name then first name
     */
    private String getLastNameBasedKey(Entry entry){
        String firstName = entry.getContact().getFirstName();
        String lastName = entry.getContact().getLastName();
        return lastName + firstName;
    }

    public AddressBook(){
        bookName = "";
        filePath = "";
        entries = new TreeMap();
    }

    public void setBookName(String name){ bookName = name; }

    public void add(Entry entry){
        if (entry != null){
            String entryKey = getLastNameBasedKey(entry);
            entries.put(entryKey, entry);
        }
    }

    public void remove(String key) { entries.remove(key); }

    /**
     * Changes order by creating new map
     * and inserting old values with
     * new keys
     */
    public void orderByZip () {
        Map<String, Entry> zipOrdered = new TreeMap<>();
        entries.forEach((String key, Entry entry) -> zipOrdered.put(getZipBasedKey(entry), entry));
        entries = zipOrdered;
    }

    public void orderByLastName(){
        Map<String, Entry> lastNameSorted = new TreeMap<>();
       entries.forEach((String key, Entry entry) -> lastNameSorted.put(getLastNameBasedKey(entry), entry));
       entries = lastNameSorted;
    }

    public void printAllEntries() {
        for (Entry entry : entries.values()){
            System.out.println(entry.toString());
            System.out.println();
        }
    }
}
