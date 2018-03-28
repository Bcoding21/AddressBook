import java.io.Serializable;

public class AddressBookEntry implements  Serializable {

    private String firstName, lastName;
    private String address, city, state, phoneNo;
    private int zipCode;

    public static class Builder{

        private String firstName, lastName;
        private String address, city, state, phoneNo;
        private int zipCode;

        public Builder(){}

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName.toLowerCase();
            return this;

        }

        public Builder address(String address){
            this.address = address.toLowerCase();
            return this;

        }

        public Builder city(String city){
            this.city = city.toLowerCase();
            return this;

        }

        public Builder state(String state){
            this.state = state.toLowerCase();
            return this;

        }

        public Builder phoneNumber(String phoneNo){
            this.phoneNo = phoneNo.toLowerCase();
            return this;
        }

        public Builder zipCode(int zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public AddressBookEntry build(){
            return new AddressBookEntry(this);
        }
    }

    private AddressBookEntry(Builder b){
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.address = b.address;
        this.city = b.city;
        this.state = b.state;
        this.phoneNo = b.phoneNo;
        this.zipCode = b.zipCode;
    }

    public AddressBookEntry(AddressBookEntry entry){
        this.firstName = entry.firstName;
        this.lastName = entry.lastName;
        this.address = entry.address;
        this.city = entry.city;
        this.state = entry.state;
        this.phoneNo = entry.phoneNo;
        this.zipCode = entry.zipCode;
    }

    public String getFirstName(){ return firstName; }

    public String getLastName () { return lastName; }

    public int getZipCode() { return zipCode; }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void editAddress(String address){ this.address = address; }

    public void editCity(String city){ this.city = city; }

    public void editState(String state) {this.state = state; }

    public void editPhoneNumber(String phoneNo){ this.phoneNo = phoneNo; }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + "\n"
                + "Zip Code: " + this.zipCode + "\n";
    }
}
