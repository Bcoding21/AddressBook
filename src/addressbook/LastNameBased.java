package addressbook;

import java.util.Map;
import java.util.TreeMap;

public class LastNameBased implements SortOrder {

    private static LastNameBased instance;

    private LastNameBased(){}

    public static LastNameBased getInstance(){
        if (instance == null){
            instance =  new LastNameBased();
        }
        return instance;
    }

    @Override
    public void sort(Map<String, Person> people) {
        Map<String, Person> nameSorted = new TreeMap<>();
        people.forEach((String key, Person person) -> nameSorted.put(getKey(person), person));
        people = nameSorted;
    }

    @Override
    public String getKey(Person person) {
        return person + person.getFirstName();
    }
}
