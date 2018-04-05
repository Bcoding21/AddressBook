import org.junit.Test;

import static org.junit.Assert.*;

public class EntryTest {

    @Test
    public void compareTo() {
        Contact contact = new Contact("Brandon", "Cole", "301-324-2025");
        Address address = new Address("2225 4th street", "Washington D.C", "Washington D.C",  20774);
        Entry entry1 = new Entry(contact, address);

        Contact contact1 = new Contact("John", "Smith", "240-292-2980");
        Address address1 = new Address("2252 4th street", "Washington D.C", "Washington D.C", 20005);
        Entry entry2 = new Entry(contact1, address1);

        assertTrue(entry1.compareTo(entry2) < 0);
    }
}