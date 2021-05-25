/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0065;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList stdList = new StudentList();
        
        boolean check = true; 
        stdList.add();
        do{
            System.out.println("Do you want to enter more student information?(Y/N): ");
            char choice = sc.nextLine().charAt(0);
            
            if (stdList.checkContinue(choice)==1){
                stdList.add();
            }else if(stdList.checkContinue(choice)==0){
                stdList.display(stdList.getPercentType());
                check = false;
            }else{
                System.out.println("Invalid option, enter again.");
            }
            
        }while(check == true);
    }
    
}
