/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0052;

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
    
    public float checkInputFloat() {
        
        while (true) {
            try {
                float result = Float.parseFloat(checkInputString());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int checkInputLimit(int min, int max){
        while (true) {            
            try{
                int result = Integer.parseInt(checkInputString());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            }catch(NumberFormatException e){
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public boolean isNullArray(EastAsiaCountries[] eastAsiaCountriesArr) {
        boolean check = true;
        for (int i = 0; i < eastAsiaCountriesArr.length; i++) {
            if (eastAsiaCountriesArr[i] != null){
                check = false;
            }
        }
        return check;
    }
    
    public boolean isDuplicated(EastAsiaCountries[] eastAsiaCountrieseArr, EastAsiaCountries country) {
        boolean check = false;
        for (int i = 0; i < 11; i++) {
            if (country.equals(eastAsiaCountrieseArr[i]))
                check = true;
        }
        return check;
    }
}
