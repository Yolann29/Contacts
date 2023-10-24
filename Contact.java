import java.util.Scanner;

public class Contact {

    public Contact(String name, String number) {
        this.contactName = name;
        this.contactNumber = number;
    }

    public String getName() {
        return this.contactName;
    }

    public String getNumber() {
        return this.contactNumber;
    }

    public void setName(String newName) {
        this.contactName = newName;
    }

    public void setNumber(String newNumber) {
        this.contactNumber = newNumber;
    }

    public void modify() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChanges for the contact named: " + this.contactName + "\nEnter his new name (press enter if you don't want to change it):");
        String newName = scanner.nextLine();
        int count = 0;
        if (newName.equalsIgnoreCase("")) {
            newName = this.contactName;
            count = count + 1;
        }
        System.out.println("\nCurrent number registered: " + this.contactNumber + "\nEnter his new number:");
        String newNumber = scanner.nextLine();
        if (newNumber.equalsIgnoreCase("")) {
            newNumber = this.contactNumber;
            count = count + 1;
        }
        if (count != 2) {
            System.out.println("\n\tOld name: " + this.contactName + "\n\tOld number: " + this.contactNumber + "\n\nChanges applicated:" + "\n\n\tNew name: " + newName + "\n\tNew number: " + newNumber);
        } else {
            System.out.println("\nNo changes applicated:\n\n\tName: " + newName + "\n\tNumber: " + newNumber);
        }
        this.setName(newName);
        this.setNumber(newNumber);
    }

    public boolean validNumber() {
        if (this.contactNumber.length() == 10 && this.contactNumber.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }

    public void styleName() {
        StringBuilder styleName = new StringBuilder(this.contactName.toLowerCase());
        styleName = styleName.deleteCharAt(0);
        styleName = styleName.append(Character.toUpperCase(styleName.charAt(0)));
        this.contactName = styleName.toString();
    }

    private String contactName;
    private String contactNumber;
}