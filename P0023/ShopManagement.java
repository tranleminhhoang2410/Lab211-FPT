package Nhom2_Lab211_LongAssignment;

import java.util.ArrayList;

public class ShopManagement {
    private final Validate validate = new Validate();
    protected ArrayList<Fruit> fruitList = new ArrayList<>();
    
    //create fruit information
    public Fruit createFruit(){
        Fruit fruit = new Fruit();
        fruit.setFruitID(fruitList.size() + 1);
        System.out.println("Enter name of fruit: ");
        fruit.setFruitName(validate.checkInputString());
        System.out.println("Enter origin: ");
        fruit.setOrigin(validate.checkInputString());
        System.out.println("Enter price: ");
        fruit.setPrice(validate.checkInputDouble());
        return fruit;
    }
    
    //add fruit into shop
    public void addFruit(){
        boolean check = true;
        do{
            fruitList.add(createFruit());
            while (check) {                
                try{
                    System.out.println("Do you want to continue (Y/N): ");
                    check = validate.checkInputYesNo();
                    break;
                }catch(Exception e){
                    System.out.println("Enter again: ");
                }
            }
        }while(check);
    }
    
    //print available fruit list from shop 
    public void displayFruitList(){
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for(Fruit f: fruitList){
            System.out.println(f);
        }
    }
    
    
}