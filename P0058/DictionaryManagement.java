package P0058;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DictionaryManagement {
    private HashMap<String, String> dictionaryMap = new HashMap<>();
    
    public void updateDatabase(String path){
        File file = new File(path);
        try{
            if(file.exists()){
                ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(path));
                data.writeObject(dictionaryMap);
                data.close();
            }
        }catch(Exception e){

        }
    }

    public void loadData(String path){
        File file = new File(path);
        if(file.exists()){
            try{
                ObjectInputStream data = new ObjectInputStream(new FileInputStream(path));
                dictionaryMap = (HashMap<String, String>)data.readObject();
                data.close();
            }catch(Exception e){

            }
        }
    }

    public String getWord(String language){
        Validate validate = new Validate();
        System.out.print("Enter " + language + ": ");
        String word = validate.checkInputWord(language);
        return word;
    }

    public boolean addWord(String en, String vi){
        if(dictionaryMap.containsKey(en)){
            return false;
        }
        dictionaryMap.put(en, vi);
        return true;
    }

    public boolean removeWord(String en){
        if(dictionaryMap == null){
            return false;
        }
        if(!dictionaryMap.containsKey(en)){
            return false;
        }
        dictionaryMap.remove(en);
        return true;
    }

    public String translate(String en){
        if(dictionaryMap == null){
            return "";
        }
        if(!dictionaryMap.containsKey(en)){
            return "";
        }
        return "Vietnamese: " + dictionaryMap.get(en);
    }
}