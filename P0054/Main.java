/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0054;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactManagement contactManagement = new ContactManagement();
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact = new Contact();
        int choice = 0;
        do{
            choice = contactManagement.showMenu();
            switch(choice){
                case 1:
                    System.out.println("-------- Add a Contact --------");
                    System.out.println(contactManagement.addContact(contactList, contact)?"SUCCESSFUl":"FAILED");
                    break;
                case 2:
                    contactManagement.displayAll(contactList);
                    break;
                case 3:
                    contactManagement.deleteContact(contactList, contact);
                    System.out.println("After delete: ");
                    contactManagement.displayAll(contactList);
                    break;
                case 4:
                    System.out.println("Exit.");
                    break;
            }
            
        }while(choice != 4);
    }
    
}
