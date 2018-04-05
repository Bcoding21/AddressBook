import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


    }

    /**
     * Used to fill address book with fake data
     * @return Random sequence of characters
     */

    public static String getRandChars(){
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append(alphabet.charAt(r.nextInt(N)));
        }
        return builder.toString();
    }

}
