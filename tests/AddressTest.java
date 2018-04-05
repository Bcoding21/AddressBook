import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void compareLessThan() {
        Address address = new Address("10731 Castleton Way", "Upper Marlboro", "Maryland", 20774);
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        int result = address.compareTo(address1);
        assertTrue(result < 0);
    }

    @Test
    public void compareGreaterThan(){
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        Address address = new Address("10731 Castleton Way", "Upper Marlboro", "Maryland", 20774);
        int result = address1.compareTo(address);
        assertTrue(result > 0);
    }


    @Test
    public void compareEqual(){
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        Address address = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        assertTrue(address.compareTo(address1) == 0);
    }

    @Test
    public void compareStreetAddress(){
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        Address address = new Address("2224 4th street", "Washington D.C", "Washington D.C", 20005);
        assertTrue(address.compareTo(address1) < 0);
    }

    @Test
    public void compareCity(){
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        Address address = new Address("2225 4th street", "Vashington D.C", "Washington D.C", 20005);
        assertTrue(address.compareTo(address1) < 0);
    }

    @Test
    public void compareZip(){
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        Address address = new Address("2225 4th street", "Washington D.C", "Washington D.C", 10005);
        assertTrue(address.compareTo(address1) < 0);
    }

    @Test
    public void compareState(){
        Address address1 = new Address("2225 4th street", "Washington D.C", "Washington D.C", 20005);
        Address address = new Address("2225 4th street", "Washington D.C", "Vashington D.C", 20005);
        assertTrue(address.compareTo(address1) < 0);
    }

    @Test
    public void compareCaseSensitivity(){
        Address address1 = new Address("2225 4th Street", "Washington D.C", "WasHington D.C", 20005);
        Address address = new Address("2225 4th street", "washington D.C", "Washington D.C", 20005);
        assertTrue(address.compareTo(address1) == 0);
    }

}