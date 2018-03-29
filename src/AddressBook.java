import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {

    private String bookName;
    private String filePath;
    private Set<Entry> entries;

    public AddressBook(){
        bookName = "";
        filePath = "";
        entries = new TreeSet<>(new Entry.lastNameComparator());
    }

    public String getFilePath() { return filePath; }

    public void setFilePath(String filePath) { this.filePath = filePath; }

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
                entry.getContactData().getPhoneNumber().compareTo(phoneNumber) == 0);
    }

    public void orderByZip () {
        Set<Entry> zipOrdered = new TreeSet<>(new Entry.zipComparator());
        zipOrdered.addAll(entries);
        entries = zipOrdered;
    }

    public void orderByLastName(){
        Set<Entry> lastNameOrdered = new TreeSet<>(new Entry.lastNameComparator());
        lastNameOrdered.addAll(entries);
        entries = lastNameOrdered;
    }

    public void printAllEntries() {
        for (Entry entry : entries){
            System.out.println(entry.toString());
            System.out.println();
        }
    }

}
