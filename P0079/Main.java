package P0079;


public class Main {
    public static void showMenu() {
        System.out.println("========= Zipper program =========");
        System.out.println("1. Compression.");
        System.out.println("2. Extraction.");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
    }

    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();
        Validate validate = new Validate();
        int choice;
        do{
            showMenu();
            choice = validate.checkInputInt();
            switch(choice){
                case 1:
                    System.out.println("---------- Compression --------");
                    System.out.print("Enter Source Folder: ");
                    String pathSource = validate.checkInputString();
                    if (!validate.checkExistFolder(pathSource)){
                        break;
                    }
                    System.out.print("Enter Destination Folder: ");
                    String desSource = validate.checkInputString();
                    if (!validate.checkExistFolder(desSource)){
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = validate.checkInputString();
                    if (fileManagement.compressTo(pathSource, name + ".zip", desSource)) {
                        fileManagement.showAllFile(pathSource);
                        System.out.println("Successfully");
                    } else {
                        System.out.println("Source Folder is empty");
                    }
                    break;
                case 2:
                    System.out.println("---------- Extraction ---------");
                    System.out.print("Enter Source file: ");
                    String fileSource = validate.checkInputString();
                    if (!validate.checkFile(fileSource))
                        break;
                    System.out.print("Enter Destination Folder: ");
                    desSource = validate.checkInputString();
                    if (!validate.checkExistFolder(desSource))
                        break;
                    if (fileManagement.extractTo(fileSource, desSource)) {
                        fileManagement.showAllFile(desSource);
                        System.out.println("Successfully");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Option is not available !!");
                    System.out.println("Choose again !!");
            }
        }while(choice != 3);
    }
    

}
