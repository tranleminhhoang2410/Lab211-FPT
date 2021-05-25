
package P0054;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ContactManagement {
    private Scanner sc = new Scanner(System.in);
    private Validate validate = new Validate();

    public boolean addContact(List<Contact> list, Contact contact) {
        contact.setID(list.size() + 1);
        System.out.println("Enter First Name: ");
        contact.setFirstName(validate.checkInputString());
        System.out.println("Enter Last Name: ");
        contact.setLastName(validate.checkInputString());
        contact.setFullname(contact.getFirstName() + " " + contact.getLastName());
        System.out.println("Enter Group: ");
        contact.setGroup(validate.checkInputString());
        System.out.println("Enter Address: ");
        contact.setAddress(validate.checkInputString());
        contact.setPhone(validate.checkInputPhone());
        list.add(new Contact(contact.getID(), contact.getFullname(), contact.getGroup(), contact.getAddress(),
                contact.getPhone(), contact.getLastName(), contact.getFirstName()));
        return true;
    }

    public void displayAll(List<Contact> list) {
        System.out.printf("%-4s %-20s %-15s %-15s %-10s %-10s %s\n", "ID", "Name", "FirstName", "LastName", "Group",
                "Address", "PhoneNumber");
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }

    public boolean deleteContact(List<Contact> list, Contact contact) {
        System.out.println("Enter ID: ");
        int idCheck = validate.checkInputID(list);
        list.remove(idCheck - 1);
        for (int i = idCheck - 1; i < list.size(); i++) {
            list.get(i).setID(list.get(i).getID() - 1);
        }
        return true;
    }

    public int showMenu() {
        System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.println("Choose an option: ");
        int choice = validate.checkInputLimit(1, 4);
        return choice;
    }
}
