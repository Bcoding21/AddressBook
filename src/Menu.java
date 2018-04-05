import java.io.*;
import java.util.Scanner;

public class Menu {
    /**
     * Used to manipulate an Address Book class
     * Supported operations are deal with storing
     * and retrieving address book classes from files.
     * Works with one address book at one time
     */
    private File file;
    private AddressBook addressBook;
    private final String outputDirPath = "AddressBooks\\";

    public AddressBook open(String path){
        if (addressBook != null){
            close();
        }
        try {
            file = new File(outputDirPath + path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
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
        file = new File(outputDirPath + "TestBook.bin");
        save();
    }

    AddressBook createNew() {
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
