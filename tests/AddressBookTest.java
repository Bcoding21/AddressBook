import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private Contact contact = new Contact("Brandon", "Cole", "240-374-2961");
    private Address address = new Address("10731 Castleton Way",
            "Upper Marlboro", "Maryland", 20774);
    private Entry entry = new Entry(contact, address);

    private Address address2 = new Address("2225 4th Street", "Washington D.C",
            "Washington D.C", 20005);
    private Contact contact2 = new Contact("John", "Smith", "240-453-8795");
    private Entry entry2 = new Entry(contact2, address2);

    @Test
    public void remove() {
        AddressBook book = new AddressBook();
        book.add(entry);
        assertTrue(book.remove(entry));
    }

    @Test
    public void add() {
        AddressBook book = new AddressBook();
        book.add(entry);
        Set<Entry> entries = book.getEntries();
        assertTrue(entries.contains(entry));
    }

    @Test
    public void orderByZip() {
        Set<Entry> entrySet = new TreeSet<>(new Entry.zipComparator());
        entrySet.add(entry);
        entrySet.add(entry2);

        List<Entry> actual = new ArrayList<>(entrySet);

        List<Entry> expected = new ArrayList<>();
        expected.add(entry2);
        expected.add(entry);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void orderByLastName() {
        Set<Entry> entrySet = new TreeSet<>(new Entry.lastNameComparator());
        entrySet.add(entry2);
        entrySet.add(entry);

        List<Entry> actual = new ArrayList<>(entrySet);

        List<Entry> expected = new ArrayList<>();
        expected.add(entry);
        expected.add(entry2);
        assertTrue(actual.equals(expected));
    }
}