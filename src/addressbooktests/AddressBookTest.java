package addressbooktests;

import addressbook.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;


public class AddressBookTest extends TestCase {

    private Person personB = new Person.Builder()
            .firstName("Brandon")
            .lastName("Cole")
            .zipCode(20774)
            .build();
    private Person personA = new Person.Builder()
            .firstName("John")
            .lastName("Smith")
            .zipCode(30005)
            .build();


    @Test
    public void testRemove() {
        AddressBook book = new AddressBook();
        Person person = new Person.Builder()
                .firstName("Mic")
                .lastName("Jackson!")
                .build();
        book.add(person);
        Ordering order = LastNameOrdered.getInstance();
        boolean removed = book.remove(order.getKey(person));
        assertTrue(removed);
    }

    @Test
    public void testAdd() {
        AddressBook book = new AddressBook();
        Person person = new Person.Builder()
                .firstName("Jaylen")
                .lastName("Brown!")
                .build();
        book.add(person);
        assertTrue(book.size() == 1);
    }

    @Test
    public void testOrderByZip() {
        AddressBook book = new AddressBook();
        book.sortBy("zip");
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
        AddressBook book = new AddressBook();
        book.add(personA);
        book.add(personB);
        List<Person> actual = new ArrayList<>(book.getEntries().values());
        List<Person> expected = new ArrayList<>();
        expected.add(personB);
        expected.add(personA);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void testChangeState(){
        AddressBook book  = new AddressBook();
        Person person = new Person.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .state("DC")
                .build();
        book.add(person);
        Ordering order = OrderFactory.getInstance().getOrder("lastname");
        String key = order.getKey(person);
        book.changeState(key, "MD");
        Person person1 = book.getPerson(key);
        assertTrue(person1.getState().equals("MD"));
    }

    @Test
    public void testChangeCity(){
        AddressBook book  = new AddressBook();
        Person person = new Person.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .city("j")
                .build();
        book.add(person);
        Ordering order = OrderFactory.getInstance().getOrder("lastname");
        String key = order.getKey(person);
        book.changeCity(key, "k");
        Person person1 = book.getPerson(key);
        assertTrue(person1.getCity().equals("k"));
    }

    @Test
    public void testChangeZip(){
        AddressBook book  = new AddressBook();
        book.sortBy("zip");
        Person person = new Person.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .zipCode(20774)
                .build();
        book.add(person);
        Ordering order = OrderFactory.getInstance().getOrder("zip");
        String key = order.getKey(person);
        book.changeZip(key, 20005);
        Person person1 = book.getPerson(order.getKey(person));
        assertTrue(person1.getZipCode() == 20005);
    }

    @Test
    public void testChangeStreetAddress(){
        AddressBook book  = new AddressBook();
        Person person = new Person.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .streetAddress("101")
                .build();
        book.add(person);
        Ordering order = OrderFactory.getInstance().getOrder("lastname");
        String key = order.getKey(person);
        book.changeStreetAddress(key, "202");
        Person person1 = book.getPerson(key);
        assertTrue(person1.getStreetAddress().equals("202"));
    }

    @Test
    public void testNoName(){
        Person person = new Person.Builder()
                .firstName("").lastName("").build();
        AddressBook book = new AddressBook();
        book.add(person);
        Person person1 = book.getPerson("");
        assertNull(person1);
    }
}