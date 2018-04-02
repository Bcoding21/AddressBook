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

    public Menu(){}

    public AddressBook open(String path){

        try{
            file = new File(path);
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
            FileOutputStream input = new FileOutputStream(file, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        file = new File(scanner.nextLine());
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

}