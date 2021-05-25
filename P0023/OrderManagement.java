package Nhom2_Lab211_LongAssignment;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class OrderManagement extends ShopManagement {
    private final Validate validate = new Validate();
    private Hashtable<String, ArrayList<BuyingOption>> orderHashtable = new Hashtable<>();
    
    //create a buying option
    public BuyingOption createOption(){
        BuyingOption order = new BuyingOption();
        int i = validate.checkProductAvailable(fruitList);
        order.setProduct(fruitList.get(i - 1).getFruitName());
        System.out.println("You selected: " + order.getProduct());
        order.setQuantity(validate.checkInputQuantity());
        order.setPrice(fruitList.get(i - 1).getPrice());
        order.setAmount(order.getQuantity() * order.getPrice());
        return order;
    }

    //print list of buying option
    public void displayOptionList(ArrayList<BuyingOption> list){
        System.out.println("Product | Quantity | Price | Amount");
        for(BuyingOption o: list){
            System.out.println(o);
        }
        System.out.println("Total: " + calculateTotalMoney(list)+"$");
    }
    
    //create list of buying option
    public ArrayList<BuyingOption> createOptionList(){
        ArrayList<BuyingOption> optionList = new ArrayList<>();
        boolean check = true;
        do{
            if(fruitList.isEmpty()){
                System.out.println("Shop does not have any fruit");
            }else{
                displayFruitList();
                optionList.add(createOption());
                while (true){
                    try{
                        System.out.println("Do you want to order now (Y/N).");
                        check = validate.checkInputYesNo();
                        break;
                    }catch(Exception e){
                        System.out.println("Invalid option.");
                    }
                }
            }
               
        }while(!check);
        return optionList;
    }
    
    //create Order by adding buying option list
    public void createOrder(){
       
        if(createOptionList().isEmpty()){
            System.out.println("Sorry for this problem !!");
        }else{
            ArrayList<BuyingOption> newOptionList = createOptionList();
            displayOptionList(newOptionList);    
            System.out.println("Input your name: ");
            String name = validate.checkInputString();
            orderHashtable.put(name, newOptionList);
        }
    }
    
    public double calculateTotalMoney(ArrayList<BuyingOption> list){
        double total = 0;
        for(BuyingOption o: list){
            total += o.getAmount();
        }
        return total;
    }
    
    public void displayAllOrders(){
        if (orderHashtable.isEmpty()){
            System.out.println("Does not have any order !!");
            System.out.println("");
        }else{
            Set<String> nameSet = orderHashtable.keySet();
            for(String name: nameSet){
                System.out.println("Customer: " + name);
                displayOptionList(orderHashtable.get(name));
                System.out.println("");
            }
        }
    }
    
}