import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact victor = new Contact("VICTOR","0783426747");
        contacts.add(victor);
        Contact pascal = new Contact("pascal","0614826467");
        contacts.add(pascal);
        Contact nina = new Contact("NiNA","0689574236");
        contacts.add(nina);
        Contact vivianne = new Contact("viVIAnne","0610789376");
        contacts.add(vivianne);
        victor.styleName();
        System.out.println(victor.getName());
        pascal.styleName();
        System.out.println(pascal.getName());
        nina.styleName();
        System.out.println(nina.getName());
        vivianne.styleName();
        System.out.println(vivianne.getName());
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (exit == false) {
            System.out.println("\nWrite what action do you want to do:\n - Create\n - Modify\n - Number\n - Delete\n - Display all\n - Exit\n\n");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("Create")) {

                contacts.add(create(contacts));

            } else if (action.equalsIgnoreCase("Modify")) {

                boolean cancel = false;
                while (cancel == false) {
                    System.out.println("\nWhich contact do you want to change ?");
                    String contactName = scanner.nextLine();
                    if (nameExist(contactName, contacts) == true ) {
                        find(contactName, contacts).modify();
                        cancel = true;
                    } else {
                        System.out.println("\nThe name you give does not correspond to any contact.\nWrite 'cancel' to abort or press enter to retry.\n\n");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("cancel")) {
                            cancel = true;
                        }
                    }
                }

            } else if (action.equalsIgnoreCase("Number")) {

                boolean cancel = false;
                while (cancel == false) {
                    System.out.println("\nWhich contact number do you want ?");
                    String contactName = scanner.nextLine();
                    if (nameExist(contactName, contacts) == true ) {
                        Contact contact = find(contactName, contacts);
                        System.out.println("\nThe number of the contact " + contact.getName() +" is: " + contact.getNumber());  
                        cancel = true;
                    } else {
                        System.out.println("\nThe name you give does not correspond to any contact.\nWrite 'cancel' to abort or press enter to retry.");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("cancel")) {
                            cancel = true;
                        }
                    }
                }

            } else if (action.equalsIgnoreCase("Delete")) {

                boolean cancel = false;
                while (cancel == false) {
                    System.out.println("\nWrite the contact name that you want to delete:");
                    String contactName = scanner.nextLine();
                    if (nameExist(contactName, contacts) == true ) {
                        Contact contact = find(contactName, contacts);
                        System.out.println("\nThe contact " + contact.getName() + " will be deleted.\nAre you sure you want to continue.\tY/N?");  
                        String delete = scanner.nextLine();
                        if (delete.equalsIgnoreCase("Y")) {
                            contacts.remove(contact);
                            System.out.println("\nContact deleted successfully!!!");
                            cancel = true;
                        } else {
                            System.out.println("\nWrite 'cancel' to abort or press enter to retry.");
                            String response = scanner.nextLine();
                            if (response.equalsIgnoreCase("cancel")) {
                                cancel = true;
                            }
                        }
                    } else {
                        System.out.println("\nThe name you give does not correspond to any contact.\nWrite 'cancel' to abort or press enter to retry.");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("cancel")) {
                            cancel = true;
                        }
                    }
                }

            } else if (action.equalsIgnoreCase("Display all")) {

                System.out.println("\nThis is the list of the current contacts registered\n\n");
                for (int i=0; i<contacts.size(); i++) {
                    System.out.println(contacts.get(i).getName() + " : " + contacts.get(i).getNumber());
                }

            } else if (action.equalsIgnoreCase("Exit")) {
                exit = true;
                System.out.println("\n\n\nClosing contacts application\n");
            } else {
                System.out.println("\nI dont understand, please write an existed action");
            }
            if (exit == false) {
                System.out.println("\n\nPress enter to continue.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static Contact create(ArrayList<Contact> contacts) {
        Scanner scanner = new Scanner(System.in);
        boolean nameCorrect = false;
        String name = "";
        String number = "";
        Contact contact = new Contact(name, number);
        while (nameCorrect == false) {
            System.out.println("\nEnter the contact name:");
            name = scanner.nextLine();
            if (nameExist(name, contacts) == true) {
                System.out.println("\nName already used, please try another one.");
            } else {
                nameCorrect = true;
            }
        }
        boolean numCorrect = false;
        while (numCorrect == false) {
            System.out.println("\nEnter his corresponding contact number:");
            number = scanner.nextLine();
            if (numExist(number, contacts) == true) {
                System.out.println("\nNumber already atributed, please try another one.");
            } else {
                contact = new Contact(name, number);
                if (contact.validNumber() == true) {
                    numCorrect = true;
                } else {
                    System.out.println("\nIt is not a valid phone number, please try another one.");
                }
            }
        }
        System.out.println("\nContact successfully created!!\n\nName: " + name + "\n" + "Number: " + number);
        return contact;
    }

    public static boolean nameExist(String contactName, ArrayList<Contact> contacts) {
        boolean exist = false;
        for (int i=0; i<contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                exist = true;
            }
        }
        return exist;
    }

    public static boolean numExist(String contactNumber, ArrayList<Contact> contacts) {
        boolean exist = false;
        for (int i=0; i<contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getNumber().equalsIgnoreCase(contactNumber)) {
                exist = true;
            }
        }
        return exist;
    }

    public static Contact find(String contactName, ArrayList<Contact> contacts) {
        Contact contactWanted = new Contact("a","1");
        for (int i=0; i<contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                contactWanted = contact;
            }
        }
        return contactWanted;
    }
}