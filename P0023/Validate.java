package Nhom2_Lab211_LongAssignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                return input;
            }
        }
    }
    
    public int checkInputInt() {
        while (true) {
            try {
                int input = Integer.parseInt(checkInputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Must be input int");
                System.out.println("Enter again: ");
            }

        }
    }

    public double checkInputDouble() {
        while (true) {
            try {
                double input = Double.parseDouble(checkInputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Must be input double");
                System.out.println("Enter again: ");
            }

        }
    }
    
    public boolean checkInputYesNo() {
        while (true) {
            String input = checkInputString();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("y")) {
                return true;
            }else if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("n")) {
                return false;
            }else{
                System.out.println("Please input y/Y or n/N.");
                System.out.println("Enter again: ");
            }
        }
    }

    public int checkInputQuantity(){
        while(true){
            try{
                System.out.print("Please input quantity: ");
                int quantity = Integer.parseInt(checkInputString());
                if(quantity > 0){
                    return quantity;
                }else{
                    throw new Exception();
                }    
            }catch(NumberFormatException e){
                System.out.println("Quantity must be integer number");
            }catch (Exception e){
                System.out.println("Quantity must be larger than 0");
            }
        }
    }
    
    public int checkProductAvailable(ArrayList list){
        while(true){
            try{
                System.out.print("Select Product: ");
                int product = checkInputInt();
                if(product <= 0 || product >= list.size() + 1){
                    throw new IndexOutOfBoundsException();
                }
                return product; 
            }catch(IndexOutOfBoundsException e){
                System.out.println("Item not found, try again.");
            }
        }
    }
}
