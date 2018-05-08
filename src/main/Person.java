package main;

import java.io.Serializable;

/**
 * Represents a person's contact information. Attributes
 * include a person's last name, first name, city, street address,
 * state, zip code, and phone number. All fields except first and last
 * name are mutable.
 */

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String phoneNumber;

    /**
     * private constructor that takes in an object of type builder
     * and copies all its attributes.
     * @param builder inner class of Person class that builds a Person class attribute by attribute.
     */
    private Person(Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        streetAddress = builder.streetAddress;
        city = builder.city;
        state = builder.state;
        zipCode = builder.zipCode;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *  Builder method doesn't force one to have all attributes set
     *  when Person class is created (helpful for unit testing)
     *  Also looks cleaner when setting attributes as opposed to
     *  having 7 arguments in a constructor
     */
    public static class Builder{

        private String streetAddress;
        private String city;
        private String state;
        private int zipCode;
        private String firstName;
        private String lastName;
        private String phoneNumber;


        /**
         * Creates a person object by calling the Person class
         * private constructor which takes a builder object.
         * @return Person object which had its attributes copied from the builder object
         */
        public Person build(){
            return new Person(this);
        }

        /**
         * Sets attribute and returns the builder object that called this method
         * to allow chaining (.setFirstName(f).setLastName(f).setCity)
         * @param firstName String the represents someones first name.
         * @return Builder object containing updated attribute.
         */
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder streetAddress(String streetAddress){
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder state(String state){
            this.state = state;
            return this;
        }

        public Builder zipCode(int zipCode){
            this.zipCode = zipCode;
            return this;
        }
    }

    /**
     * Transforms attributes into string.
     * @return String that is in mailing format
     */

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstName).append(" ").append(lastName)
                .append("\n").append(streetAddress).append("\n")
                .append(city).append(", ").append(state).append(" ")
                .append(zipCode);
        return builder.toString();
    }
}
