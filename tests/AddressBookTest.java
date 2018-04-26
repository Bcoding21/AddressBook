import junit.extensions.TestSetup;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private Person personA = new Person.Builder()
            .firstName("Brandon")
            .lastName("Cole")
            .phoneNumber("222")
            .city("Upper")
            .state("MD")
            .streetAddress("10831")
            .zipCode(30013)
            .build();

    private Person personB = new Person.Builder()
            .firstName("John")
            .lastName("Smith")
            .phoneNumber("240-453-8795")
            .city("Washington D.C")
            .state("Washington D.C")
            .streetAddress("2225 4th Street")
            .zipCode(20005)
            .build();

    private Order zipOrder = new ZipOrder();
    private Order nameOrder = new LastNameOrder();

    @Test
    public void remove() {
        AddressBook book = new AddressBook();
        book.add(personA);
        assertTrue(book.remove(nameOrder.getKey(personA)));
    }

    @Test
    public void add() {
        AddressBook book = new AddressBook();
        book.add(personA);
        assertTrue(book.remove(nameOrder.getKey(personA)));
    }

    @Test
    public void orderByZip() {
        AddressBook book = new AddressBook();
        book.setOrder(zipOrder);
        book.add(personA);
        book.add(personB);

        List<Person> actual = new ArrayList<>(book.getEntries().values());

        List<Person> expected = new ArrayList<>();
        expected.add(personB);
        expected.add(personA);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void orderByLastName() {
        AddressBook book = new AddressBook();
        book.add(personB);
        book.add(personA);

        List<Person> actual = new ArrayList<>(book.getEntries().values());

        List<Person> expected = new ArrayList<>();
        expected.add(personA);
        expected.add(personB);
        assertTrue(actual.equals(expected));
    }
}