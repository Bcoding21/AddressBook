import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {

    private String bookName;
    private Set<Entry> entries;

    public AddressBook(){
        bookName = "AddressBook";
        entries = new TreeSet<>(new Entry.NameComparator());
    }

    public AddressBook(AddressBook addressBook){
        entries = addressBook.entries;
    }

    public void setBookName(String name){ bookName = name; }

    public void add(Entry entry){
        if (entry != null){
            entries.add(entry);
        }
    }

    public boolean remove(String phoneNumber) {
        return entries.removeIf((Entry entry) ->
                entry.getContact().getPhoneNumber().compareTo(phoneNumber) == 0);
    }

    public void orderByZip () {
        Set<Entry> zipOrdered = new TreeSet<>(new Entry.ZipCodeComparator());
        zipOrdered.addAll(entries);
        entries = zipOrdered;
    }

    public void orderByLastName(){
        Set<Entry> lastNameOrdered = new TreeSet<>(new Entry.NameComparator());
        lastNameOrdered.addAll(entries);
        entries = lastNameOrdered;
    }

    public void printAllEntries() {

    }

}
