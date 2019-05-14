package main;

import java.util.Map;
import java.util.TreeMap;

public class AddressBook {

	private Map<String, Contact> lastNameIndex;
    private Map<Integer, Contact> zipCodeIndex; 

    public AddressBook() {
    	lastNameIndex = new TreeMap<>();
    	zipCodeIndex = new TreeMap<>();
    }
    
    public boolean add(Contact contact) {
    	Contact contactCopy = new Contact(contact);
		String lastName = contactCopy.getLastName();
		contactCopy = lastNameIndex.put(lastName, contactCopy);
		
		if (contactCopy == null) {
			return false;
		}
		
		int zipCode = contact.getZipCode();
		contactCopy = zipCodeIndex.put(zipCode, contact);
		return contactCopy == null;
	}
    
    public boolean remove(Contact contact) {
    	return false;
    }
    
    public int getSize() {
		return lastNameIndex.size();
	}

}
