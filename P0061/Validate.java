/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0061;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString(){
        while (true) {            
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("Cannot be empty !!");
                System.out.println("Enter again: ");
            }else{
                return  result;
            }
        }
    }
    
    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(checkInputString());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Input again.");
            }
        }
    }
}
