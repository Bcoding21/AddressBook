package main;

import java.io.*;

public class Menu {
    /**
     * Used to manipulate an Address Book class
     * Supported operations are deal with storing
     * and retrieving address book classes from files.
     * Works with one address book at one time
     */

    private String currFilePath;
    private AddressBook addressBook;

    public Menu(){
        currFilePath = null;
        addressBook = null;
    }

    public AddressBook open(String path){

        try {
            currFilePath = path;
            FileInputStream fileInputStream = new FileInputStream(new File(currFilePath));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            if (addressBook != null){
                close();
            }
            addressBook = (AddressBook) objectInputStream.readObject();
        }
        catch (EOFException e){
            return null;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }

        return addressBook;
    }

    public void saveAs() throws IOException {
        currFilePath = "book2.bin";
        save();
    }

    public void save() throws IOException {
        if (currFilePath == null){
            saveAs();
            return;
        }
        try {
            FileOutputStream input = new FileOutputStream( currFilePath, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddressBook createNew() {
        addressBook = new AddressBook();
        return addressBook;
    }

    public void close(){
        currFilePath = null;
        addressBook = null;
    }

    public void quit(){
        System.exit(0);
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public String getCurrFilePath() {
        return currFilePath;
    }


}
