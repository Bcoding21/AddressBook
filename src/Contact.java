import java.io.Serializable;

public class Contact implements Serializable {
    /**
     * Used to model data about a person's contact
     * information. Supports methods that get and
     * set attributes.
     */
    private String firstName;
    private String lastName;
    private String phoneNumber;

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

