

public class Main {



    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        AddressBookEntry entry = new AddressBookEntry.Builder()
                .firstName("Brandon")
                .lastName("Cole")
                .zipCode(20774)
                .build();

        AddressBookEntry entry2 = new AddressBookEntry.Builder()
                .firstName("Brandon")
                .lastName("Bole")
                .zipCode(20774)
                .build();


        addressBook.add(entry);
        addressBook.add(entry2);

        addressBook.sortByZip();
        addressBook.sortByLastName();



        System.out.println(addressBook);
    }





}
