import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {

    /**
     * Used to represent an address book. Supports
     * operations such as add, remove, and sort order.
     * Sorts entries by last name initially.
     */

    private Set<Entry> entrySet;

    public AddressBook(){ entrySet = new TreeSet<>(); }

    public AddressBook(AddressBook addressBook){ entrySet = new TreeSet<>(addressBook.entrySet); }

    public void add(Entry entry){
        if (entry != null){
          entrySet.add(entry);
        }
    }

    public boolean remove(Entry entry) {
        return entry != null && entrySet.remove(entry);
    }

    public void orderByZip () {
       Set<Entry> zipOrdered = new TreeSet<>(new Entry.zipComparator());
       zipOrdered.addAll(entrySet);
       entrySet = zipOrdered;
    }

    public void orderByLastName(){
        Set<Entry> nameOrdered = new TreeSet<>(new Entry.lastNameComparator());
        nameOrdered.addAll(entrySet);
        entrySet = nameOrdered;
    }

    public void printAllEntries() {}
}
