/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0052;

/**
 *
 * @author ADMIN
 */
public class ManageEastAsiaCountries {
    private EastAsiaCountries eastAsiaCountries = new EastAsiaCountries();
    private EastAsiaCountries[] eastAsiaCountrieseArr = new EastAsiaCountries[11];
    private Validate validate = new Validate();
    private int index = 0;
    
    public EastAsiaCountries inputEastAsiaCountries(){
        System.out.println("Enter code of country: ");
        eastAsiaCountries.setCountryCode(validate.checkInputString());
        System.out.println("Enter name of country: ");
        eastAsiaCountries.setCountryName(validate.checkInputString());
        System.out.println("Enter total area: ");
        eastAsiaCountries.setTotalArea(validate.checkInputFloat());
        System.out.println("Enter terrain of country: ");
        eastAsiaCountries.setCountryTerrain(validate.checkInputString());
        return new EastAsiaCountries(eastAsiaCountries.getCountryTerrain(), eastAsiaCountries.getCountryCode(), eastAsiaCountries.getCountryName(), eastAsiaCountries.getTotalArea());
    }
    
    public void addCountryInformation(EastAsiaCountries country) throws Exception{
        if (validate.isDuplicated(eastAsiaCountrieseArr, country)){
            throw new Exception("Country is duplicated");
        }
        eastAsiaCountrieseArr[index++] = country;
    }
    
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception{
        if (validate.isNullArray(eastAsiaCountrieseArr)){
            throw new Exception("Database is empty");
        }    
        return eastAsiaCountrieseArr[index - 1];
    }
    
    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        if(validate.isNullArray(eastAsiaCountrieseArr)){
            throw new Exception("Database is empty");
        }
        EastAsiaCountries[] countriesSearched = new EastAsiaCountries[11];
        int countriesSearchedIndex = 0;
        for (int i = 0; i < 11; i++){
            if(eastAsiaCountrieseArr[i] == null){
                continue;
            }
            if(eastAsiaCountrieseArr[i].getCountryName().contains(name)){
                countriesSearched[countriesSearchedIndex] = eastAsiaCountrieseArr[i];
                ++countriesSearchedIndex;
            }
        }
        return countriesSearched;
    }
    
    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception{
        if(validate.isNullArray(eastAsiaCountrieseArr)){
            throw new Exception("Database is empty");
        }    
        for(int i = 0; i < index; i++){
                for(int j= index - 1; j > i; j--){
                    if(eastAsiaCountrieseArr[j].getCountryName().compareTo(eastAsiaCountrieseArr[j - 1].getCountryName()) <= 0){
                        EastAsiaCountries temp = eastAsiaCountrieseArr[j];
                        eastAsiaCountrieseArr[j] = eastAsiaCountrieseArr[j - 1];
                        eastAsiaCountrieseArr[j - 1] = temp;
                    }
                }
        }
        return eastAsiaCountrieseArr;
    }
    
    public void displayCountries(EastAsiaCountries[] eastAsiaCountriesArr) {
        System.out.printf("%-15s %-20s %-25s %-20s %n", "ID", "Name", "Total Area", "Terrain");
        for (int i = 0; i < eastAsiaCountriesArr.length; i++) {
            if (eastAsiaCountriesArr[i] == null){
                continue;
            }
            eastAsiaCountriesArr[i].display();
        }
    }
    
    public int showMenu(){
        System.out.println("                                 MENU                                     ");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
        System.out.println("Please choose an option: ");
        int choice = validate.checkInputLimit(1, 5);
        return choice;
    }
    
    
}
