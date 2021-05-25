/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0081;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BeeList bList = new BeeList();
        int choice;
        do{
            bList.showMenu();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    bList.createBeeList();
                    bList.display();
                    break;
                case 2:
                    bList.attack();
                    bList.display();
                    break;
                case 3:
                    System.out.println("Quit.");
                    break;
                default:
                    System.out.println("Option is not available !!");
            }
            
        }while(choice != 3);
    }
    
}
