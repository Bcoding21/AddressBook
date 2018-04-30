package addressbook;

public class SortOrderFactory {

    private static SortOrderFactory instance;

    private SortOrderFactory() {}

    public static SortOrderFactory getInstance() {
        if (instance == null){
            instance = new SortOrderFactory();
        }
        return instance;
    }

    public SortOrder getOrder(String criteria){

        if (criteria == null){
            return null;
        }

        if (criteria.equals("zip")){
            return ZipBased.getInstance();
        }

        if (criteria.equals("lastname")){
            return LastNameBased.getInstance();
        }

        return null;
    }
}
