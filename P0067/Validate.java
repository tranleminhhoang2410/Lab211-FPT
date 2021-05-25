package P0067;

import java.util.Scanner;

public class Validate {
    private Scanner sc = new Scanner(System.in);

    public String checkInputString(){
        while(true){
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Cannot be empty: ");
                System.out.print("Enter again: ");
            }else{
                return input;
            }
        }
    }
    
    public boolean checkPerfectSquareNumber(int number){
        if(Math.sqrt(number) * Math.sqrt(number) == number){
            return true;
        }
        return false;
    }

    public boolean checkOddNumber(int number){
        if(number % 2 == 1){
            return true;
        }
        return false;
    }

    public boolean checkEvenNumber(int number){
        if(number % 2 == 0){
            return true;
        }
        return false;
    }
}
