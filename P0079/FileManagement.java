package P0079;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class FileManagement {

    public boolean compressTo(String pathSrc, String fileName, String pathCompress) {
        File src = new File(pathSrc);
        if (src.isDirectory()) {
            File[] folder = src.listFiles();
            if (folder.length == 0)
                return false;
            try {
                ZipOutputStream fileZipper = new ZipOutputStream(
                        new FileOutputStream(pathCompress + File.separator + fileName));
                for (File file : folder) {
                    FileInputStream fileReader = new FileInputStream(file);
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    fileZipper.putNextEntry(zipEntry);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fileReader.read(bytes)) >= 0) {
                        fileZipper.write(bytes, 0, length);
                    }
                    fileReader.close();
                }
                fileZipper.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                ZipOutputStream fileZipper = new ZipOutputStream(new FileOutputStream(fileName));
                FileInputStream fileReader = new FileInputStream(src);
                ZipEntry zipEntry = new ZipEntry(src.getName());
                fileZipper.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fileReader.read(bytes)) >= 0) {
                    fileZipper.write(bytes, 0, length);
                }
                fileReader.close();
                fileZipper.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;

    }

    public boolean extractTo(String pathZipFile, String pathExtract) {
        byte[] bytes = new byte[1024];
        try {
            File src = new File(pathZipFile);
            ZipInputStream fileUnzipper = new ZipInputStream(new FileInputStream(src));
            ZipEntry zipEntry = fileUnzipper.getNextEntry();
            while (zipEntry != null) {
                File unzippedFile = new File(pathExtract + File.separator + zipEntry.getName());

                new File(unzippedFile.getParent()).mkdirs();
                FileOutputStream fileWriter = new FileOutputStream(unzippedFile);
                int length;
                while ((length = fileUnzipper.read(bytes)) >= 0) {
                    fileWriter.write(bytes, 0, length);
                }
                fileWriter.close();
                zipEntry = fileUnzipper.getNextEntry();
            }
            fileUnzipper.closeEntry();
            fileUnzipper.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void showAllFile(String pathSource) {
        File src = new File(pathSource);
        for (File file : src.listFiles()) {
            System.out.println(file.getName());
        }
    }
}