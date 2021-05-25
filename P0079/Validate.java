package P0079;

import java.io.File;
import java.util.Scanner;

public class Validate {
    private Scanner sc = new Scanner(System.in);
    public String checkInputString(){
        while(true){
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Can not be empty !!");
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
                System.out.println("Must input an integer number !!");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkInputYesNo() {
        while (true) {
            String input = checkInputString();
            if (input.equalsIgnoreCase("Y"))
                return true;
            if (input.equalsIgnoreCase("N"))
                return false;
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter choice: ");
        }
    }

    public boolean checkExistFolder(String pathSource) {
        File src = new File(pathSource);
        if (!src.isDirectory()) {
            System.out.println("Path does not exist. Do you want to create? (Y/N)");
            System.out.print("Enter choice: ");
            if (checkInputYesNo()) {
                try {
                    src.mkdirs();
                    System.out.println(src.getAbsolutePath() + " created successfully");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else
                return false;
        }
        return true;
    }

    public boolean checkEmptyFolder(String pathSource) {
        File src = new File(pathSource);
        try {
            if (src.listFiles().length == 0) {
                System.out.println("Folder is empty");
                return false;
            }

        } catch (Exception e) {
        }
        return true;
    }

    public boolean checkFile(String fileSource) {
        File src = new File(fileSource);
        if (!src.isFile()) {
            System.out.println("Cannot find this file");
            return false;
        } else {
            if (!fileSource.endsWith(".zip")) {
                System.out.println("Not support this file format");
                return false;
            }
            return true;
        }
    }
}
