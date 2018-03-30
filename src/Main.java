import java.util.Random;

public class Main {

    public static void main(String[] args) {

        FileMenu menu = new FileMenu();
        AddressBook addressBook = menu.createNewBook();
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact(getRandChars(), getRandChars(), getRandChars());
            Address address = new Address(getRandChars(),
                    getRandChars(), getRandChars(), rand.nextInt(100000) + 1);
            addressBook.add(new Entry(contact, address));
        }

        addressBook.orderByZip();
        addressBook.orderByLastName();
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
