package P0077;

import java.util.Scanner;

public class Validate {
    private Scanner sc = new Scanner(System.in);
    
    public String checkInputString(){
        while(true){
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Can not be empty !");
                System.out.print("Enter again: ");
            }else{
                return input;
            }
        }
    }

    public int checkInputInt(){
        while(true){
            try {
                int input = Integer.parseInt(checkInputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Must be an integer number !");
                System.out.print("Enter again: ");
            }
        }
    }
}
