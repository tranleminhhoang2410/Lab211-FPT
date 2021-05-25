package Nhom2_Lab211_LongAssignment;


public class Main {
    public static void showMenu(){
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }
    
    public static void main(String[] args) {
        OrderManagement orderManagement = new OrderManagement();
        Validate validate = new Validate();
        int choice;
        do { 
            showMenu();           
            choice = validate.checkInputInt();
            switch (choice){
                case 1:
                    orderManagement.addFruit();
                    break;
                case 2:
                    orderManagement.displayAllOrders();
                    break;
                case 3:
                    orderManagement.createOrder();
                    break;
                case 4:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Option is not available !!");
                    System.out.println("");
            }
        }while (choice != 4);
    }
}