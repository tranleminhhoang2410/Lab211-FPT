package P0062;

import java.util.StringTokenizer;

public class FileManagement {
    Validate validate = new Validate();

    public String getPath(String path) {
        if (validate.isFileAvailable(path)) {
            return path.substring(0, path.lastIndexOf("\\"));
        } else {
            return path.substring(0, path.length());
        }
    }

    public String getFileName(String path) {
        String fileName;
        if (validate.isFileAvailable(path)) {
            fileName = path.substring(path.lastIndexOf("\\") + 1, path.lastIndexOf("."));
        } else {
            fileName = "No File Here !!";
        }
        return fileName;
    }

    public String getExtension(String path) {
        String extension;
        if (validate.isFileAvailable(path)) {
            extension = path.substring(path.lastIndexOf(".") + 1, path.length());
        } else {
            extension = "No Data Here";
        }
        return extension;
    }

    public String getDisk(String path) {
        return path.substring(0, path.indexOf("\\"));
    }

    public String[] getFolders(String path) {
        String s;
        int index = 0;
        if (validate.isFileAvailable(path)) {
            s = path.substring(path.indexOf("\\") + 1, path.lastIndexOf("\\"));
        } else {
            s = path.substring(path.indexOf("\\") + 1, path.length());
        }
        StringTokenizer st = new StringTokenizer(s, "\\");
        String[] arr = new String[st.countTokens()];
        while (st.hasMoreTokens()) {
            arr[index] = st.nextToken();
            index++;
        }
        return arr;
    }

}
