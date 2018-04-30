package tests;

import addressbook.AddressBook;
import addressbook.Menu;
import org.junit.Test;

import static org.junit.Assert.*;

 public class MenuTest {

    @Test
    public void testOpen() {
        Menu menu = new Menu();
        AddressBook book = menu.open("TestBook.bin");
        assertTrue(book.equals(menu.getAddressBook()));
    }

    @Test
    public void testSave() {
        Menu menu = new Menu();
        menu.createNew();
        menu.save();
        assertTrue(menu.getFile().exists());
    }

    @Test
    public void testSaveAs() {
    }

    @Test
    public void testCreateNew() {
        Menu menu = new Menu();
        AddressBook book = menu.createNew();
        assertTrue(book == menu.getAddressBook());
    }

    @Test
    public void testClose() {
        Menu menu = new Menu();
        menu.createNew();
        menu.save();
        menu.close();
        assertTrue(menu.getAddressBook() == null && menu.getFile() == null);
    }
}