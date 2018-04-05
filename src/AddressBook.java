import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {
    /**
     * Used to represent an address book with entries
     * stored as a treeSet. Supports basic operations
     * operations such as add, remove, and sorting by
     * certain values. Sorts entries by last name initially.
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

    void orderByZip(){
        Set<Entry> zipOrdered = new TreeSet<>(new Entry.zipComparator());
        zipOrdered.addAll(entrySet);
        entrySet = zipOrdered;
    }

    void orderByLastName(){
        Set<Entry> lastNameOrdered = new TreeSet<>(new Entry.lastNameComparator());
        lastNameOrdered.addAll(entrySet);
        entrySet = lastNameOrdered;
    }

    public void printAllEntries() {}

    public Set getEntries(){ return entrySet; }
}
