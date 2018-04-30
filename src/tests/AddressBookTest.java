package tests;

import addressbook.AddressBook;
import addressbook.LastNameBased;
import addressbook.Person;
import addressbook.SortOrder;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;
import java.util.*;


public class AddressBookTest extends TestCase {

    private AddressBook book;
    private Person personA;
    private Person personB;
    private Person personC;
    private String criteria_1;
    private File dataFile;

    public AddressBookTest(String path){
        dataFile = new File(path);
    }

    private AddressBook readData() throws IOException {

        AddressBook book = new AddressBook();

        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        String line;

        while ((line = reader.readLine()) != null){

            String[] words = line.split(" ");

            Person person = new Person.Builder()
                    .firstName(words[0])
                    .lastName(words[1])
                    .streetAddress(words[2])
                    .city(words[3])
                    .state(words[4])
                    .zipCode(Integer.parseInt(words[5]))
                    .build();

            book.add(person);

        }
        return book;
    }

    @Override
    protected void setUp() throws IOException {
        book = readData();
        personA = book.getEntries().get("ColeBrandon");
        personB = book.getEntries().get("ColeMalcolm");
        criteria_1 = "zip";

    }

    @Test
    public void testRemove() {
        Person person = new Person.Builder()
                .firstName("Mic")
                .lastName("Jackson!")
                .build();
        book.add(person);
        SortOrder order = LastNameBased.getInstance();
        assertTrue(book.remove(order.getKey(person)));
    }

    @Test
    public void testAdd() {
        Person person = new Person.Builder()
                .firstName("Jaylen")
                .lastName("Brown!")
                .build();
        book.add(person);
        SortOrder order = LastNameBased.getInstance();
        assertTrue(book.remove(order.getKey(personA)));
    }

    @Test
    public void testOrderByZip() {
        book.sortBy(criteria_1);
        book.add(personA);
        book.add(personB);
        List<Person> actual = new ArrayList<>(book.getEntries().values());
        List<Person> expected = new ArrayList<>();
        expected.add(personB);
        expected.add(personA);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void testOrderByLastName() {
        book.add(personB);
        book.add(personA);
        List<Person> actual = new ArrayList<>(book.getEntries().values());
        List<Person> expected = new ArrayList<>();
        expected.add(personA);
        expected.add(personB);
        assertTrue(actual.equals(expected));
    }
}