import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private Contact contact = new Contact("Brandon", "Cole", "240-374-2961");
    private Address address = new Address("10731 Castleton Way",
            "Upper Marlboro", "Maryland", 20774);
    private BookEntry bookEntry = new BookEntry(contact, address);

    private Address address2 = new Address("2225 4th Street", "Washington D.C",
            "Washington D.C", 20005);
    private Contact contact2 = new Contact("John", "Smith", "240-453-8795");
    private BookEntry bookEntry2 = new BookEntry(contact2, address2);

    @Test
    public void remove() {
        AddressBook book = new AddressBook();
        book.add(bookEntry);
        book.orderByZip();
        String key = "20774ColeBrandon";
        BookEntry bookEntry = book.remove(key);
        assertTrue(bookEntry != null);
    }

    @Test
    public void add() {
        AddressBook book = new AddressBook();
        book.add(bookEntry2);
        assertTrue(book.remove("SmithJohn") != null);
    }

    @Test
    public void orderByZip() {
        AddressBook book = new AddressBook();
        book.orderByZip();

        book.add(bookEntry);
        book.add(bookEntry2);

        List<BookEntry> actual = new ArrayList<>(book.getEntries().values());

        List<BookEntry> expected = new ArrayList<>();
        expected.add(bookEntry2);
        expected.add(bookEntry);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void orderByLastName() {
        AddressBook book = new AddressBook();

        book.add(bookEntry2);
        book.add(bookEntry);

        List<BookEntry> actual = new ArrayList<>(book.getEntries().values());

        List<BookEntry> expected = new ArrayList<>();
        expected.add(bookEntry);
        expected.add(bookEntry2);
        assertTrue(actual.equals(expected));
    }
}