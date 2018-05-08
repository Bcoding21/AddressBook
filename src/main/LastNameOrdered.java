package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * Used to change and maintain the ordering of entries
 * within AddressBook.
 */

public class LastNameOrdered implements Ordering {

    private static LastNameOrdered instance;

    private LastNameOrdered(){}

    public static LastNameOrdered getInstance(){
        if (instance == null){
            instance =  new LastNameOrdered();
        }
        return instance;
    }

    /**
     * Rearranges order of entries according to last name
     * by creating a new tree and inserting the same values
     * with new keys.
     * @param entries
     */
    @Override
    public void order(Map<String, Person> entries) {
        Map<String, Person> nameSorted = new TreeMap<>();
        entries.forEach((String key, Person person)
                -> nameSorted.put(getKey(person), person));
        entries = nameSorted;
    }


    /**
     * Generates key based on the concatenation of lastName and firstName
     * attributes of the Person object.
     * @param person Person object that contains contact information
     * @return String that uniquely identifies the Person object
     */
    @Override
    public String getKey(Person person) {
        return person.getLastName() + person.getFirstName();
    }
}
