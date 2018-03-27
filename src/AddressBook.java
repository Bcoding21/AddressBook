import java.util.*;

public class AddressBook  {

    private Set<AddressBookEntry> entries;

    public AddressBook(){ entries = new TreeSet<>(); }

    public AddressBook(AddressBook addressBook){
        entries = addressBook.entries;
    }

    public void add(AddressBookEntry person){ entries.add(person); }

    public void remove(AddressBookEntry addressBookEntry) {
        entries.remove(addressBookEntry);
    }

    public void sortByZip () {
        Set<AddressBookEntry> zipSortedEntries = new TreeSet<>(Comparator.comparingInt(AddressBookEntry::getZipCode)
        .thenComparing(AddressBookEntry::getLastName).thenComparing(AddressBookEntry::getFirstName));
        zipSortedEntries.addAll(entries);
        entries = zipSortedEntries;
    }

    public void sortByLastName(){
        Set<AddressBookEntry> nameSortedEntries = new TreeSet<>(Comparator.comparing(AddressBookEntry::getLastName)
        .thenComparing(AddressBookEntry::getFirstName));
        nameSortedEntries.addAll(entries);
        entries = nameSortedEntries;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (AddressBookEntry entry : entries){
            builder.append(entry.toString());
        }
        return builder.toString();
    }
}
