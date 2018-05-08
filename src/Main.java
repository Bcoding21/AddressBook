import addressbook.AddressBook;
import addressbook.Menu;
import addressbook.Person;

import java.io.IOException;
import java.util.Scanner;

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