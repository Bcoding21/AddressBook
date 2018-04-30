package addressbook;

import java.io.*;
import java.util.Scanner;

public class Menu {
    /**
     * Used to manipulate an Address Book class
     * Supported operations are deal with storing
     * and retrieving address book classes from files.
     * Works with one address book at one time
     */
    private File file, dir;
    private AddressBook addressBook;

    public Menu(){
        file = null;
        dir = null;
        addressBook = null;
    }

    public Menu(String path){
        dir = new File(path);
        file = null;
        addressBook = null;
    }

    public AddressBook open(String path){

        try {
            file = new File(dir, path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            if (addressBook != null){
                close();
            }
            addressBook = (AddressBook) objectInputStream.readObject();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        return addressBook;
    }

    public void save() {
        if (file == null){
            saveAs();
            return;
        }
        try {
            FileOutputStream input = new FileOutputStream( file, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs() {
        String fileName;
        System.out.println("Enter filename: ");
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();
        file = new File(dir, fileName);
        save();
    }

    public AddressBook createNew() {
        addressBook = new AddressBook();
        return addressBook;
    }

    public void close(){
        file = null;
        addressBook = null;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public File getFile() {
        return file;
    }
}
