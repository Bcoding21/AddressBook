import java.io.Serializable;

public class Address implements Serializable{

    /**
     * Used to model a person's complete address.
     * Supports getter and setter operations.
     * Compared by using state, then zip code, then
     * zip code, then street address.
     * */

    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;

    public Address(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress.toLowerCase();
        this.city = city.toLowerCase();
        this.state = state.toLowerCase();
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress.toLowerCase();
    }

    public void setCity(String city) {
        this.city = city.toLowerCase();
    }

    public void setState(String state) {
        this.state = state.toLowerCase();
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
