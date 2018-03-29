import java.io.Serializable;


public class ContactData implements Comparable<ContactData>, Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public ContactData(String first, String last, String number){
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

    @Override
    public int compareTo(ContactData o) {
        String f1 = lastName + firstName;
        String f2 = o.lastName + o.firstName;

        int res = f1.compareTo(f2);

        if (res != 0){
            return res;
        }

        return phoneNumber.compareTo(o.phoneNumber);
    }
}

