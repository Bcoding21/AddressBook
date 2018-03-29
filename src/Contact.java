import java.io.Serializable;
import java.util.Comparator;

public class Contact implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(){
        firstName = "";
        lastName = "";
        phoneNumber = "";
    }

    public Contact(String first, String last, String number){
        firstName = first.toLowerCase();
        lastName = last.toLowerCase();
        phoneNumber = number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}

