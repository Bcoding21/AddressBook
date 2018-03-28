import java.io.*;
import java.util.Random;

public class Main {



    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        Random rand = new Random();

        try( BufferedReader reader = new BufferedReader(new FileReader(new File("nameList.txt")))){
            String line;
            while ((line = reader.readLine()) != null){
                String words[] = line.split(" ");
                AddressBookEntry entry = new AddressBookEntry.Builder()
                        .firstName(words[0])
                        .lastName(getRandChars())
                        .city(getRandChars())
                        .phoneNumber(getRandChars())
                        .address(getRandChars())
                        .state(getRandChars())
                        .zipCode(rand.nextInt(100000) + 1)
                        .build();
                addressBook.add(entry);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        addressBook.printAllEntries();


    }

    public static String getRandChars(){
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append(alphabet.charAt(r.nextInt(N)));
        }
        return builder.toString();
    }

}
