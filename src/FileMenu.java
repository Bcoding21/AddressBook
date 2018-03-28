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

    public void save(AddressBook addressBook) {

        if (file == null || file.exists()) {
            saveAs();
        }
        else{
            try {
                FileOutputStream input = new FileOutputStream(file, false);
                ObjectOutputStream objectOut = new ObjectOutputStream(input);
                objectOut.writeObject(addressBook);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveAs() {
        file = new File("newFilePath");

        try{
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(addressBook);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
