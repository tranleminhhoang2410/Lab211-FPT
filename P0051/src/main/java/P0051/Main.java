/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0051;

import java.util.Scanner;

/**
 *
 * @author M Hoang
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.showMenu();
        int choice;
        do{
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    methods.normalCalculator();
                    break;
                case 2:
                    methods.BMICalculator();
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Option is not available.");
            }
        }while(choice != 3);
    }
    
}
