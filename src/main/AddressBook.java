package main;

import java.io.Serializable;
import java.util.*;


public class AddressBook implements Serializable {

	private Map<String, Contact> lastNameIndex;
    private Map<Integer, Contact> zipCodeIndex; 


    public AddressBook() {
    	lastNameIndex = new TreeMap<>();
    	zipCodeIndex = new TreeMap<>();
    }
    
    public boolean add(Contact contact) {
		return false;
	}
    
    public boolean remove(Contact contact) {
    	return false;
    }

}
