import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMenu {

    private File file;
    private List<AddressBook> openBooks;
    private final String outputDirPath = "AddressBooks\\";

    public FileMenu(){
        openBooks = new ArrayList<>();
        file = new File(outputDirPath);
        file.mkdir();
    }

    public AddressBook open(String path){

        AddressBook addressBook = new AddressBook();
        try{
            file = new File(outputDirPath + path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            addressBook = (AddressBook) objectInputStream.readObject();
            openBooks.add(addressBook);
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
            FileOutputStream input = new FileOutputStream(outputDirPath + path, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs(String path, AddressBook addressBook) {

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
        AddressBook addressBook = new AddressBook();
        openBooks.add(addressBook);
        return addressBook;
    }

    public void close(AddressBook addressBook){
        openBooks.remove(addressBook);
    }

}
