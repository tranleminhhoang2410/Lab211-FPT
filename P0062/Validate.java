package P0062;

import java.io.File;
import java.util.Scanner;

public class Validate {
    private Scanner sc = new Scanner(System.in);

    public String checkInputString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Can not be empty !");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    public String checkPathFormat(String input) throws Exception {
        char[] notationArr = { '*', '<', '>', '?', '/', '|', '~', '#', '%', '&', '{', '}', '\"', '\'' };
        for (int i = 0; i < notationArr.length; i++) {
            if (input.indexOf(notationArr[i]) != -1) {
                throw new Exception();
            }
        }
        return input;
    }

    public boolean isFileAvailable(String path) {
        if (path.substring(path.lastIndexOf("\\") + 1, path.length()).contains(".")) {
            return true;
        } else {
            return false;
        }
    }

}