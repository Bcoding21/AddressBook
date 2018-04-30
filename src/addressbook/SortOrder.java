package addressbook;

import java.util.Map;

public interface SortOrder {
    void sort(Map<String, Person> person);
    String getKey(Person person);
}

