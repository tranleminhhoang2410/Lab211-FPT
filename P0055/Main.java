/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoctorHash doctorHash = new DoctorHash();
        CheckInput checkInput = new CheckInput();
        int choice;
        do {
            doctorHash.showMenu();
            choice = checkInput.checkInputInt();
            switch(choice){
                case 1:
                    doctorHash.add();
                    doctorHash.display();
                    break;
                case 2:
                    doctorHash.update();
                    doctorHash.display();
                    break;
                case 3:
                    doctorHash.delete();
                    doctorHash.display();
                    break;
                case 4:
                    doctorHash.search();
                    break;
                case 5:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Option is not available");
            }
        } while (choice != 5);
    }
    
}
