import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {

    /**
     * Represents an Address Book and is implemented as
     * a TreeMap for fast insertion, deletion, sorting, and
     * removal of duplicates. Uses a concatenation of fields
     * as a key and entrys as the value. Can order entrys by
     * name or zipCode and insert or remove entrys and
     * other operations
     */

    private String bookName;
    private String filePath;
    private Map<String, Entry> entries;

    /**
     * Used to generate a unique key for an entry
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
