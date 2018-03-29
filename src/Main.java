import java.util.Random;

public class Main {

    public static void main(String[] args) {

        FileMenu menu = new FileMenu();
        AddressBook addressBook = menu.createNewBook();

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
