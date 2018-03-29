import java.io.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        FileMenu menu = new FileMenu();

        AddressBook addressBook[] = new AddressBook[10];

        for (int i = 0; i < addressBook.length; i++){
            String num = Integer.toString(i + 1);
            addressBook[i] = menu.open("addressBook" + num + ".bin");
        }




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
