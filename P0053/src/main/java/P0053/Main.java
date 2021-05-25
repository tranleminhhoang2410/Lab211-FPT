/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0053;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        int []arr = new int[0];
        Methods method = new Methods();
        do{
            method.showMenu();
            choice = method.checkInputInt();
            switch(choice){
                case 1:
                    System.out.println("----- Input Element -----");
                    arr = method.inputElement();
                    break;
                case 2:
                    System.out.println("----- Ascending -----");
                    method.sortAscending(arr);
                    break;
                case 3:
                    System.out.println("----- Descending -----");
                    method.sortDscending(arr);
                    break;
                case 4:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Option is not available !!");
            }
        }while(choice != 4);
    }
    
}
