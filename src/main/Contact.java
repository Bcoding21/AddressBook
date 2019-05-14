package main;

import java.io.Serializable;

/**
 * Represents a person's contact information. Attributes
 * include a person's last name, first name, city, street address,
 * state, zip code, and phone number. All fields except first and last
 * name are mutable.
 */

public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;
	
	
	public Contact(String firstName, String lastName, Address address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

   
}
