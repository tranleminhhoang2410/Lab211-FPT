package P0077;

import java.io.*;
import java.util.StringTokenizer;

public class WordManagement {
    public int countWord(String path, String word) throws FileNotFoundException, IOException{
        int count = 0;
        InputStream inputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = "";

        while((line = reader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line, ",.()[]{}\\/\';:\" ");
            while(st.hasMoreTokens()){
                if(st.nextToken().equalsIgnoreCase(word)){
                    count ++;
                }
            }
        }
        inputStreamReader.close();
        reader.close();
        return count;
    }

    public void getFileName(String path, String word){
        File f = new File(path);
        String[] list = f.list();
        if(list == null){
            System.out.println("No data available");
        }else{
            try{
                for(int i = 0; i < list.length; i++){
                    if(countWord(path + "\\" + list[i], word) != 0){
                        System.out.println(list[i]);
                    }
                }
            }catch(FileNotFoundException e){
                System.out.println("No File available !!");
            }catch(IOException e){
                System.out.println("File error !!");
            }
        }
    }
}
