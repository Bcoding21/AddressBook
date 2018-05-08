package tests;

import main.AddressBook;
import main.Menu;
import main.Person;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;

public class MenuTest extends TestCase {

    @Test
    public void testOpen() throws IOException {
        AddressBook book = new Menu().open("book2.bin");
        assertNotNull(book.getPerson("ColeBrandon"));
    }

    @Test
    public void testSave() throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        AddressBook book =  menu.createNew();
        Person person = new Person.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .build();
        book.add(person);
        menu.save();

        FileInputStream fileInputStream = new FileInputStream(new File("book2.bin"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        AddressBook book2 = (AddressBook) objectInputStream.readObject();
        assertNotNull(book2.getPerson("ColeBrandon"));
    }

    @Test
    public void testCreateNew() {
       AddressBook book = new Menu().createNew();
       assertTrue(book.size() == 0);
    }

    @Test
    public void testClose() {
        Menu menu = new Menu();
        AddressBook book = menu.createNew();
        Person person = new Person.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .build();
        book.add(person);
        menu.close();
        assertTrue(menu.getCurrFilePath() == null && menu.getAddressBook() == null);
    }
}