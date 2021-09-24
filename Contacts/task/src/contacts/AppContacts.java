package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class AppContacts {

        ArrayList<Contact> appContacts= new  ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        public Contact add(){

                String name="";
                String surname="";
                String phoneNumber="";

                System.out.println("Enter the name of the person: ");

                name = scanner.nextLine();

                System.out.println("Enter the surname of the person: ");

                surname = scanner.nextLine();

                System.out.println("Enter the number: ");

                phoneNumber = scanner.nextLine();

                Contact contact = new Contact(name, surname, phoneNumber);

                System.out.println("A record created!\n" +
                        "A Phone Book with a single record created!");

                appContacts.add(contact);

                return contact;

        }

        public void Actions() {

                String action;

                System.out.println("Enter action (add, remove, edit, count, list, exit): ");

                action = scanner.nextLine();

                switch (action) {

                        case "add":
                                add();
                                Actions();
                                break;
                        case "list":
                                list();
                                Actions();
                                break;
                        case "edit":
                                edit();
                                Actions();
                                break;
                        case "count":
                                count();
                                Actions();
                                break;
                        case "remove":
                                remove();
                                Actions();
                                break;
                        case "exit":
                                break;

                }
        }

        public void list() {

                for(int i = 0; i<appContacts.size();i++){

                        Contact temp = appContacts.get(i);

                        System.out.println(i + 1 + ". " + temp.getName() + " " + temp.getSurname()
                                +", " + temp.getPhoneNumber());
                }

        }

        public void count() {

                System.out.println(appContacts.size() + " records");



        }

        public void remove(){

                list();

                System.out.println("Select a record: >");

                String record = scanner.nextLine();

                int recordNumber = Integer.parseInt(record);

                appContacts.remove(recordNumber-1);

                System.out.println("The record removed!");

        }

        public void edit() {

                String tempName="";
                String tempSurname="";
                String tempNumber="";

                System.out.println("Select a record: >");

                String record = scanner.nextLine();

                int recordNumber = Integer.parseInt(record);

                Contact tempContact = appContacts.get(recordNumber-1);

                tempName = tempContact.getName();
                tempSurname = tempContact.getSurname();
                tempNumber = tempContact.getPhoneNumber();

                System.out.println("Select a field (name, surname, number): >");

                String fieldName = scanner.nextLine();

                switch(fieldName){

                        case "name":
                                System.out.println("Enter name: >");
                                tempName = scanner.nextLine();
                                break;
                        case "surname":
                                System.out.println("Enter surname: >");
                                tempSurname = scanner.nextLine();
                                break;
                        case "number":
                                System.out.println("Enter number: >");
                                tempNumber = scanner.nextLine();
                                break;
                }

                appContacts.set(recordNumber-1, new Contact(tempName, tempSurname, tempNumber));


        }

}
