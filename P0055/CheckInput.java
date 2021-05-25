/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class CheckInput {
    private Scanner sc = new Scanner(System.in);
    
    
    public String checkInputEmpty(){
        while(true){
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Can not be empty, enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid, enter again: ");
            }
        }
    }
}
