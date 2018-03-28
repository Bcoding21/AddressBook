import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {

    private Set<AddressBookEntry> entries;

    public AddressBook(){ entries = new TreeSet<>(Comparator
            .comparing(AddressBookEntry::getLastName)
            .thenComparing(AddressBookEntry::getFirstName)
            .thenComparing(AddressBookEntry::getAddress)
            .thenComparing(AddressBookEntry::getCity)
            .thenComparing(AddressBookEntry::getPhoneNo)
            .thenComparing(AddressBookEntry::getZipCode));
    }

    public AddressBook(AddressBook addressBook){
        entries = addressBook.entries;
    }

    public void add(AddressBookEntry person){ entries.add(person); }

    public boolean remove(String phoneNumber) {
        return entries.removeIf((AddressBookEntry entry) -> phoneNumber.equals(entry.getPhoneNo()));
    }

    public void orderByZip () {

        Set<AddressBookEntry> zipSortedEntries = new TreeSet<>(Comparator
                .comparingInt(AddressBookEntry::getZipCode)
                .thenComparing(AddressBookEntry::getLastName)
                .thenComparing(AddressBookEntry::getFirstName)
                .thenComparing(AddressBookEntry::getAddress)
                .thenComparing(AddressBookEntry::getCity)
                .thenComparing(AddressBookEntry::getState)
                .thenComparing(AddressBookEntry::getPhoneNo));

        zipSortedEntries.addAll(entries);
        entries = zipSortedEntries;
    }

    public void orderByLastName(){

        Set<AddressBookEntry> nameSortedEntries = new TreeSet<>(Comparator
                .comparing(AddressBookEntry::getLastName)
                .thenComparing(AddressBookEntry::getFirstName)
                .thenComparing(AddressBookEntry::getAddress)
                .thenComparing(AddressBookEntry::getCity)
                .thenComparing(AddressBookEntry::getState)
                .thenComparing(AddressBookEntry::getPhoneNo)
                .thenComparing(AddressBookEntry::getZipCode));
        nameSortedEntries.addAll(entries);
        entries = nameSortedEntries;
    }

    public void printAllEntries(){

        for (AddressBookEntry entry : entries){

            System.out.println(entry.toString());
            System.out.println();

        }
    }
}
