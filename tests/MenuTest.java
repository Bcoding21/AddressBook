import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void open() {
        Menu menu = new Menu();
        AddressBook book = menu.open("TestBook.bin");
        assertTrue(book.equals(menu.getAddressBook()));
    }

    @Test
    public void save() {
        Menu menu = new Menu();
        menu.createNew();
        menu.save();
        assertTrue(menu.getFile().exists());
    }

    @Test
    public void saveAs() {
    }

    @Test
    public void createNew() {
        Menu menu = new Menu();
        AddressBook book = menu.createNew();
        assertTrue(book == menu.getAddressBook());
    }

    @Test
    public void close() {
        Menu menu = new Menu();
        menu.createNew();
        save();
        menu.close();
        assertTrue(menu.getAddressBook() == null && menu.getFile() == null);
    }
}