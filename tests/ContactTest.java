import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void compareFirst(){
        Contact contact = new Contact("Brandon", "Cole", "301-324-2025");
        Contact contact1 = new Contact("Austin", "Cole", "273-333-2194");
        assertTrue(contact.compareTo(contact1) > 0);
    }

    @Test
    public void compareLast(){
        Contact contact = new Contact("Brandon", "Cole", "301-324-2025");
        Contact contact1 = new Contact("Brandon", "Washington", "273-333-2194");
        assertTrue(contact.compareTo(contact1) < 0);
    }

    @Test
    public void compareNumber(){
        Contact contact = new Contact("Brandon", "Cole", "301-324-2025");
        Contact contact1 = new Contact("Brandon", "Cole", "273-333-2194");
        assertTrue(contact.compareTo(contact1) > 0);
    }

    @Test
    public void testSensitivity(){
        Contact contact = new Contact("Brandon", "Cole", "301-324-2025");
        Contact contact1 = new Contact("BRANDON", "COLE", "301-324-2025");
        assertTrue(contact.compareTo(contact1) == 0);

    }
}