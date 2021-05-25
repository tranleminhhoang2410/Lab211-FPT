package P0077;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void showMenu(){
        System.out.println("============ Word Program =========");
        System.out.println("1. Count Word In File");
        System.out.println("2. Find File By Word");
        System.out.println("3. Exit.");
        System.out.print("Please choose an option: ");
    }
    public static void main(String[] args) {
        WordManagement wordManagement = new WordManagement();
        Validate validate = new Validate();
        String path, word;
        int choice;
        do{
            showMenu();
            choice = validate.checkInputInt();
            switch(choice){
                case 1:
                    try{
                        System.out.println("-------- Count Word --------");
                        System.out.print("Enter Path: ");
                        path = validate.checkInputString();
                        System.out.print("Enter Word: ");
                        word = validate.checkInputString();
                        System.out.print("Bout: " + wordManagement.countWord(path, word));
                        System.out.println("");
                    }catch(FileNotFoundException e){
                        System.out.println("No File available !!");
                    }catch(IOException e){
                        System.out.println("File error !!");
                    }
                    break;
                case 2:
                    System.out.println("-------- Find File By Word --------");
                    System.out.print("Enter Path: ");
                    path = validate.checkInputString();
                    System.out.print("Enter Word: ");
                    word = validate.checkInputString();
                    System.out.println("------------ File Name ------------");
                    wordManagement.getFileName(path, word);
                    break;
                case 3:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Option is not available !!");
                    System.out.println("Choose again.");
                    System.out.println("");
                    break;
            }
        }while(choice != 3);
    }
}
