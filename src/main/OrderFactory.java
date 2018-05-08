package main;

import java.io.Serializable;

/**
 * Generates subtypes of Ordering interface
 * @author Brandon Cole
 */

public class OrderFactory implements Serializable{

    /**
     * An OrderFactory reference.
     */
    private static OrderFactory instance;

    private OrderFactory() {}

    /**
     * Creates a reference to a new OrderFactory object if that
     * reference is null. Then returns that reference. Allows only one
     * instance of OrderFactory to be created.
     * @return returns reference of type OrderFactory
     */
    public static OrderFactory getInstance() {
        if (instance == null){
            instance = new OrderFactory();
        }
        return instance;
    }

    /**
     * Generates subtype of Ordering specified by parameter.
     * @param criteria String that represents the type of ordering.
     * @return Ordering returns Ordering subtype
     */
    public Ordering getOrder(String criteria){

        if (criteria == null){
            return null;
        }

        if (criteria.equals("zip")){
            return ZipOrdered.getInstance();
        }

        if (criteria.equals("lastname")){
            return LastNameOrdered.getInstance();
        }

        return null;
    }
}
