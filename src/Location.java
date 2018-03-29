import java.io.Serializable;

public class Location implements Serializable{

    private String address;
    private String city;
    private String state;
    private short zipCode;

    public Location(){
        address = "";
        city = "";
        state = "";
        zipCode = 0;
    }

    public Location(String address, String city, String state, short zipCode) {
        this.address = address.toLowerCase();
        this.city = city.toLowerCase();
        this.state = state.toLowerCase();
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public short getZipCode() {
        return zipCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(short zipCode) {
        this.zipCode = zipCode;
    }

}
