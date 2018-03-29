import java.io.*;

public class FileMenu {

    private File file;
    private AddressBook addressBook;

    public FileMenu(){}

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

    public void save(String path, AddressBook addressBook) {

        try {
            FileOutputStream input = new FileOutputStream(path, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs(String path) {

        try{
            FileOutputStream out = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(addressBook);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    AddressBook createNew() { return new AddressBook();}

}
