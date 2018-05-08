package addressbooktests;

import addressbook.Person;
import junit.framework.TestCase;
import org.junit.Test;

public class PersonTest extends TestCase {
    Person person;

    @Test
    public void testGetName(){
        String name = "Brandon";
        person = new Person.Builder()
                .firstName(name)
                .build();
        System.out.print(PersonTest.class.getCanonicalName());
        assertTrue(person.getFirstName().equals(name));
    }

    @Test
    public void testGetLastName(){
        String name = "Cole";
        person = new Person.Builder()
                .lastName(name)
                .build();
        assertTrue(person.getLastName().equals(name));
    }

    @Test
    public void testGetCity(){
        String city = "Upper Marlboro";
        person = new Person.Builder()
                .city(city)
                .build();
        assertTrue(person.getCity().equals(city));
    }

    @Test
    public void testGetState(){
        String state = "Maryland";
        person = new Person.Builder()
                .state(state)
                .build();
        assertTrue(person.getState().equals(state));
    }

    @Test
    public void testGetAddress(){
        String streetAddress = "10731 Castleton Way";
        person = new Person.Builder().
                streetAddress(streetAddress)
                .build();
        assertTrue(person.getStreetAddress().equals(streetAddress));
    }




}
