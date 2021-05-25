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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ManageEastAsiaCountries manage = new ManageEastAsiaCountries();
        EastAsiaCountries eac = new EastAsiaCountries();
        Validate validate = new Validate();
        
        while (true){
            int choice = manage.showMenu();
            switch(choice){
                case 1:
                    EastAsiaCountries country = manage.inputEastAsiaCountries();
                    try {
                        manage.addCountryInformation(country);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 2:
                    System.out.printf("%-15s %-20s %-25s %-20s %n", "ID", "Name", "Total Area", "Terrain");
                    try{
                        manage.getRecentlyEnteredInformation().display();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 3:
                    System.out.println("Enter the name you want to search for: ");
                    String countrySearched = validate.checkInputString();
                    try {
                        if(validate.isNullArray(manage.searchInformationByName(countrySearched))){
                            System.out.println("Cannot find this country !");
                        }else{
                            manage.displayCountries(manage.searchInformationByName(countrySearched));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        manage.displayCountries(manage.sortInformationByAscendingOrder());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exit.");
                    break;
            }
        }
    }
    
}
