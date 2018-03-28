import java.io.*;

public class FileMenu {

    private AddressBook addressBook;
    private String currFilePath;

    public FileMenu(){}

    public AddressBook open(String path){
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
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

    public void save(AddressBook addressBook){

        try{
            FileOutputStream input = new FileOutputStream(currFilePath, false);
            ObjectOutputStream objectOut = new ObjectOutputStream(input);
            objectOut.writeObject(addressBook);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
