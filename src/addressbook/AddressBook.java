package addressbook;

import java.io.Serializable;
import java.util.*;

/**
 * Represents an address book that stores contact information.
 * Contact information is stored using a tree map. The key is composed of
 * certain pieces of contact information while the value is the full contact
 * information represented by a Person object. AddressBook supports
 * adding, removing, sorting, and editing information within the object.
 * @author Brandon Cole
 */

public class AddressBook implements Serializable {

    /**
     *  Holds contact information
     */
    private Map<String, Person> entries;

    /**
     *  Generates a subtype of Ordering interface at runtime
     */
    private OrderFactory orderFactory;

    /**
     *  Defines the order of entries and generates keys based on that order
     */
    private Ordering order;

    public AddressBook(){
        entries = new TreeMap<>();
        order = LastNameOrdered.getInstance();
        orderFactory = OrderFactory.getInstance();
    }

    /**
     * Copies data from another AddressBook object
     * @param addressBook object of type AddressBook
     */
    public AddressBook(AddressBook addressBook){
        entries = new TreeMap<>(addressBook.entries);
        order = addressBook.order;
        orderFactory = OrderFactory.getInstance();
    }

    /**
     * inserts an entry into the address book entry is not already in the address book.
     * A key (String) is derived from information from the Person object.
     * @param person this is an Object of type Person
     */
    public void add(Person person)  {
        entries.putIfAbsent(order.getKey(person), person);
    }

    /**
     * changes the ordering of entries at runtime
     * @param criteria String that tells how entries should be ordered.
     */
    public void sortBy(String criteria) {
        order = orderFactory.getOrder(criteria);
        order.order(entries);
    }

    public Person getPerson(String key){
        return entries.get(key);
    }

    public boolean remove(String key) { return entries.remove(key) != null; }

    public void changePhoneNumber(String key, String number){ entries.get(key).setPhoneNumber(number); }

    public void changeStreetAddress(String key, String address){ entries.get(key).setStreetAddress(address); }

    public void changeCity(String key, String city) { entries.get(key).setCity(city); }

    public void changeState(String key, String state){
        entries.get(key).setState(state);
    }

    public void changeZip(String key, int zipCode) {
        Person person = entries.remove(key);
        if (person != null){
            person.setZipCode(zipCode);
            this.add(person);
        }
    }

    public void printAllEntries() { entries.forEach((String key, Person entry)
            -> System.out.println(entry.toString() + "\n")); }

    public AddressBook getClone(){ return new AddressBook(this);}

    public Map<String, Person> getEntries() { return new TreeMap<>(entries); }

    public int size () {return entries.size();}
}
