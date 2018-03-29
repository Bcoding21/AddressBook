import java.io.Serializable;

public class AddressData implements Comparable<AddressData>, Serializable{

    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;

    public AddressData(String streetAddress, String city, String state, int zipCode) {
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
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int compareTo(AddressData a) {
       int res = state.compareTo(a.state);

       if (res != 0){
           return res;
       }

        res = Integer.compare(zipCode, a.zipCode);

        if (res != 0){
            return res;
        }

       res = city.compareTo(a.city);

       if (res != 0) {
           return res;
       }

       return streetAddress.compareTo(a.streetAddress);
    }
}
