import javafx.util.Pair;

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

    public void printAllEntries() {}

    public Set getEntries(){ return entrySet; }
}
