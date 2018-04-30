package addressbook;

import java.util.Map;
import java.util.TreeMap;

public class ZipBased implements SortOrder {

    private static ZipBased instance;

    private ZipBased(){}

    public static ZipBased getInstance(){
        if (instance == null){
            instance = new ZipBased();
        }
        return instance;
    }

    @Override
    public String getKey(Person person){
        return Integer.toString(person.getZipCode())
                + person.getLastName() + person.getFirstName();
    }

    @Override
    public void sort(Map<String, Person> people) {
        Map<String, Person> zipSorted = new TreeMap<>();
        people.forEach((String key, Person person) -> zipSorted.put(getKey(person), person));
        people = zipSorted;
    }
}

