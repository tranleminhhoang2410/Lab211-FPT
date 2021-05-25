/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0054;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString(){
        while(true){
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }   
    }
    
    public int checkInputLimit(int min, int max){
        while (true) {            
            try {
                int result = Integer.parseInt(checkInputString());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int checkInputID(List list){
        int result = 0;
        try {
            result = Integer.parseInt(checkInputString());
            if(result < 1 || result > list.size()){
                throw new IndexOutOfBoundsException();
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println("ID is a digit.");
            System.out.println("Enter ID again: ");
            result = checkInputID(list);
        } catch (IndexOutOfBoundsException e){
            System.out.println("No found contact.");
            System.out.println("Enter ID again: ");
            result = checkInputID(list);
        }
        return result;
    }
    
    public String checkInputPhone(){
        boolean flag;
        String input;
        do{
            String phonePattern1 = "\\d{10}";
            String phonePattern2 = "\\d{3}-\\d{3}-\\d{4}";
            String phonePattern3 = "\\d{3}-\\d{3}-\\d{4} x1234";
            String phonePattern4 = "\\d{3}-\\d{3}-\\d{4} ext1234";
            String phonePattern5 = "\\d{3}.\\d{3}.\\d{4}";
            String phonePattern6 = "\\d{3} \\d{3} \\d{4}";
            System.out.println("Enter phone: ");
            input = sc.nextLine();
            flag = (input.matches(phonePattern1)) || (input.matches(phonePattern2)) || (input.matches(phonePattern3))
            || (input.matches(phonePattern4)) || (input.matches(phonePattern5)) || (input.matches(phonePattern6));
            if(!flag){
                System.out.println("Please input Phone follow");
                System.out.println("• 1234567890");
                System.out.println("• 123-456-7890");
                System.out.println("• 123-456-7890 x1234");
                System.out.println("• 123-456-7890 ext1234");
                System.out.println("• 123.456.7890");
                System.out.println("• 123 456 7890");
            }
        }while(!flag);
        return input;
    }
    
    
}
