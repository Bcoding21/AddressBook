import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        AddressBook book = new AddressBook();
        Random rand = new Random();
        int max = 100000;

        for (int i = 0; i < max; i++){
            Contact contact = new Contact(getRandChars(), getRandChars(), getRandChars());
            Address address = new Address(getRandChars(), getRandChars(), getRandChars(), rand.nextInt(max));
            book.add(new Entry(contact, address));
        }

        book.orderByZip();
        book.orderByLastName();
        boolean passed = isSortedByName(book.getEntries());

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

    public static boolean isSortedByName(Set<Entry> entrySet){
        Iterator<Entry> iterator = entrySet.iterator();
        Entry lastEntry = iterator.next();

        while (iterator.hasNext()){
            Entry currentEntry = iterator.next();
            if (currentEntry.compareTo(lastEntry) < 0){
                return false;
            }
            lastEntry = currentEntry;
        }
        return true;
    }

}
