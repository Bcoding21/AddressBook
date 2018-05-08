package addressbook;

import java.util.Map;
import java.util.TreeMap;

public class LastNameOrdered implements Ordering {

    private static LastNameOrdered instance;

    private LastNameOrdered(){}

    public static LastNameOrdered getInstance(){
        if (instance == null){
            instance =  new LastNameOrdered();
        }
        return instance;
    }

    @Override
    public void order(Map<String, Person> entries) {
        Map<String, Person> nameSorted = new TreeMap<>();
        entries.forEach((String key, Person person)
                -> nameSorted.put(getKey(person), person));
        entries = nameSorted;
    }

    @Override
    public String getKey(Person person) {
        return person.getLastName() + person.getFirstName();
    }
}
