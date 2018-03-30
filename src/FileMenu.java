import java.io.*;

public class FileMenu {

    /**
     * Facilitates storing and retrieving of Address Books
     * from files. Also maintains a list of books currently
     * in use. Supports operations such as opening and
     * saving and closing Address Books.
     */
    private File file;
    private AddressBook addressBook;
    private final String outputDirPath = "AddressBooks\\";

    public FileMenu(){ new File(outputDirPath).mkdir(); }

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

    public void save(String path) {
        try {
            FileOutputStream input = new FileOutputStream(outputDirPath + path, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs(String path) {

        try{
            FileOutputStream out = new FileOutputStream(outputDirPath + path);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(addressBook);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    AddressBook createNewBook() {
        addressBook = new AddressBook();
        return addressBook;
    }

    public void close(){ addressBook = null; }

}
