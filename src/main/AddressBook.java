package main;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;

public class AddressBook {

	private final Map<String, Contact> lastNameIndex;
    private final Map<Integer, Contact> zipCodeIndex; 

    public AddressBook() {
    	lastNameIndex = new TreeMap<>();
    	zipCodeIndex = new TreeMap<>();
    }
    
    
    /**
     * Adds a contact to the address book.
     * @param contact Information about a person
     * @return true if addition succeeds. False otherwise.
     * @throws NullPointerException if contact is null
     */
    public boolean add(Contact contact) {
    	Objects.requireNonNull(contact, "Contact cannot be null");
    	
    	Contact contactCopy = new Contact(contact);
		String lastName = contactCopy.getLastName().toLowerCase();
		contactCopy = lastNameIndex.put(lastName, contactCopy);
		
		if (contactCopy == null) {
			return false;
		}
		
		int zipCode = contact.getZipCode();
		contactCopy = zipCodeIndex.put(zipCode, contactCopy);
		return contactCopy != null;
	}
    
    /**
     * Removes contact from the address book
     * @param contact information about a person
     * @return true if succeeds. False otherwise.
     * @throws NullPointerException if contact is null
     */
    public boolean remove(Contact contact) {
    	Objects.requireNonNull(contact, "Contact cannot be null");
    	
    	String lastName = contact.getLastName();
    	Contact removedContact = lastNameIndex.remove(lastName);
    	
    	if (removedContact != null) {
    		return true;
    	}
    	
    	int zipCode = contact.getZipCode();
    	removedContact = zipCodeIndex.remove(zipCode);
    	return removedContact != null;
    }
    
    /**
     * Returns contact using contact's last name
     * @param lastName name of contact
     * @return Contact if found else empty Optional
     */
    public Optional<Contact> findByLastName(String lastName) {
    	Contact contact = lastNameIndex.get(lastName.toLowerCase());
    	
    	if (contact == null) {
    		return Optional.empty();
    	}
    	
    	Contact contactCopy = new Contact(contact);
    	return Optional.of(contactCopy);
    }
    
    /**
     * Returns contact using contact's zip code
     * @param zipCode zip code of contact
     * @return Contact if found else empty Optional
     */
    public Optional<Contact> findByZipCode(int zipCode) {
    	Contact contact = zipCodeIndex.get(zipCode);
    	
    	if (contact == null) {
    		return Optional.empty();
    	}
    	
    	Contact contactCopy = new Contact(contact);
    	return Optional.of(contactCopy);
    }
    
    /**
     * returns the total contacts in the address book.
     * @return number of contacts
     */
    public int getTotalContacts() {
		return lastNameIndex.size();
	}

}
