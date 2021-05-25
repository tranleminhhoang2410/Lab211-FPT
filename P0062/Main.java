package P0062;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Validate validate = new Validate();
            FileManagement fileManagement = new FileManagement();
            System.out.println("===== Analysis Path Program =====");
            System.out.print("Please input Path: ");
            String path = validate.checkInputString();
            System.out.println("");

            System.out.println("");
            System.out.println("----- Result Analysis -----");
            System.out.println("Disk: " + fileManagement.getDisk(path));
            System.out.println("Extension: " + fileManagement.getExtension(path));
            System.out.println("File Name: " + fileManagement.getFileName(path));
            System.out.println("Path: " + fileManagement.getPath(path));
            System.out.print("Folders: ");
            String[] folderArr = fileManagement.getFolders(path);
            if (folderArr.length == 0) {
                System.out.println("No Folder");
            } else {
                for (String folder : folderArr) {
                    System.out.print("[" + folder + "]");
                }
            }
        } catch (Exception e) {
            System.out.println("Path is invalid !!");
        }

    }
}
