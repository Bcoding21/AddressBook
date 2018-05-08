package main;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        AddressBook book = menu.createNew();
        book.add(new Person.Builder()
        .firstName("Brandon")
        .lastName("Cole")
        .build());
        menu.save();
    }
}