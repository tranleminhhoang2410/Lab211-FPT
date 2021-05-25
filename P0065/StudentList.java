/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class StudentList {
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    
    public String checkString(String input){
        boolean check = false;
        String s = null;
        
        while(check == false){
            System.out.println(input+": ");
            s = sc.nextLine();
            if(s.isEmpty()){
                System.out.println(input + " can't be empty.");
            }else{
                check = true;
            }
        }
        
        return s;
    }
    
    public float checkMark(String input){
        
        boolean check = false;
        float a = 0;
                
        while(check == false){
            System.out.print(input+": ");
            a = sc.nextFloat();
            if(a<0){
                System.out.println(input + " must be greater than 0");
            }else if (a>10){
                System.out.println(input + " must be less than 10");
            }else{
                check = true;
            }
        }
        return a;
    }
    
    int checkContinue(char input){
        
        if(input == 'Y' || input == 'y'){
            return 1;
        }else if(input =='N' || input=='n'){
            return 0;
        }else{
            return -1;
        }
        
    }
    
    float calAverage(Student s){
        return (s.getChemistry() + s.getMath() + s.getPhysics())/3;
    }
    
    char studentType(Student s){
        if(s.getAverage()<4){
            return 'D';
        }else if (s.getAverage() <6){
            return 'C';
        }else if (s.getAverage()<=7.5){
            return 'B';
        }else{
            return 'A';
        }       
    }
    
    public Student create(){
        Student s = new Student();
        
        s.setName(checkString("Name"));
        s.setClasses(checkString("Class"));
        s.setMath(checkMark("Maths"));
        s.setChemistry(checkMark("Chemistry"));
        s.setPhysics(checkMark("Physics"));
        s.setAverage(calAverage(s));
        s.setType(studentType(s));
        
        
        return s;
    }
    
    public void add(){
        studentList.add(create());
    }
    
    public float classify(char input){
        float total = studentList.size();
        int amount=0;
        
        for (Student s : studentList){
            if(s.getType()==input){
                amount++;
            }
        }
        
        return (amount/total)*100;
    }
    
    public HashMap<String, Float> getPercentType() {    
        HashMap<String, Float> map = new HashMap<>();
        
        map.put("A: ", classify('A'));
        map.put("B: ", classify('B'));
        map.put("C: ", classify('C'));
        map.put("C: ", classify('D'));
        
        return map;
    }
    
    public void display(HashMap<String, Float> map){
        
        
        for(Student s : studentList){
            System.out.println(s.toString());
        }
        System.out.println("");
        
        
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + map.get(key)+"%");
        }
    }
    
    
}
