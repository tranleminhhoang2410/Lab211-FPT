package P0058;

public class Main {
    public static void showMenu(){
        System.out.println("======== Dictionary program ========");
        System.out.println("1. Add Word");
        System.out.println("2. Delete Word");
        System.out.println("3. Translate");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }
    public static void main(String[] args) {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        Validate validate = new Validate();
        dictionaryManagement.loadData("dictionary.txt");
        int choice;
        do{
            showMenu();
            choice = validate.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("--------- Add ---------");
                    System.out.println(dictionaryManagement.addWord(dictionaryManagement.getWord("English"), dictionaryManagement.getWord("Vietnamese")) ? "Successful": "Failed");
                    break;
                case 2:
                    System.out.println("--------- Delete ---------");
                    System.out.println(dictionaryManagement.removeWord(dictionaryManagement.getWord("English")) ? "Successful" : "Do not have this word in dictionary");
                    break;
                case 3:
                    System.out.println("--------- Translate ---------");
                    String vi = dictionaryManagement.translate(dictionaryManagement.getWord("English"));
                    System.out.println(vi.equals("") ? "This word does not exist in the dictionary" : vi);
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Option is not available !!");
                    System.out.println("Choose again.");
                    System.out.println("");
                    break;
            }
        }while(choice != 4);

        dictionaryManagement.updateDatabase("dictionary.txt");
    }
}
