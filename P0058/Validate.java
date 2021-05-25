package P0058;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private Scanner sc = new Scanner(System.in);
    
    public String checkInputString(){
        while (true) {
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Cannot be empty !!");
                System.out.print("Enter again: ");
            }else{
                return input;
            }
        }
    }

    public int checkInputInt(){
        while(true){
            try{
                int input = Integer.parseInt(checkInputString());
                return input;
            }catch(NumberFormatException e){
                System.out.println("Must be an integer number !!");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputWord(String language){
        Pattern pattern = Pattern.compile("^[a-zA-Z\s]+$");
        while(true){
            String input = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(input);
            if(input.isEmpty()){
                System.out.println("Cannot be empty !");
                System.out.print("Enter " + language + ": ");
            }else if(!matcher.find()){
                System.out.println("Word cannot contain numbers or special characters");
                System.out.print("Enter " + language + ": ");
            }else{
                return input;
            }
        }
    }
}
