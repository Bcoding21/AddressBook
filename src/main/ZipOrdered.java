package main;

import java.util.Map;
import java.util.TreeMap;

public class ZipOrdered implements Ordering {

    private static ZipOrdered instance;

    private ZipOrdered(){}

    public static ZipOrdered getInstance(){
        if (instance == null){
            instance = new ZipOrdered();
        }
        return instance;
    }

    @Override
    public String getKey(Person person){
        return Integer.toString(person.getZipCode())
                + person.getLastName() + person.getFirstName();
    }

    @Override
    public void order(Map<String, Person> entries) {
        Map<String, Person> zipSorted = new TreeMap<>();
        entries.forEach((String key, Person person) ->
                zipSorted.put(getKey(person), person));
        entries = zipSorted;

    }
}

