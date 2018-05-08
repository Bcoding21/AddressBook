package addressbook;

import java.io.Serializable;
import java.util.Map;

/**
 * Describes how an AddressBook object will sort
 * its contact information. Each subtype of this
 * interface implements its own method of sorting
 * entries. Subtypes are also responsible for defining
 * how the keys are generated since keys are defined by
 * how entries are sorted.
 */
public interface Ordering extends Serializable {

    /**
     * Orders an AddressBook objects internal map
     * based on 1 or more Person object attributes.
     * @param person Map of type <String, Person>
     */
    void order(Map<String, Person> person);

    /**
     * Returns key derived from one more attributes.
     * Used to insert Person object into tree based
     * on some order.
     * @param person Person object that contains contact information
     * @return String that uniquely identifies a Person object.
     */
    String getKey(Person person);
}

