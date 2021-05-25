/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0068;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class StudentComparator implements Comparator<Student>{
    private final Scanner sc = new Scanner (System.in);
    private final List<Student> students = new ArrayList<Student>();
    
    String checkString(String input){
        
        boolean check = false;
        String s = null;
        
        while(check == false){
            System.out.println("Enter "+input+": ");
            s = sc.nextLine();
            if(s.isEmpty()){
                System.out.println(input + " can't be empty.");
            }else{
                check = true;
            }
        }
        
        return s;
    }
    
    float checkFloat(){
        while(true){
            try{
                System.out.println("Enter Mark: ");
                float num = Float.parseFloat(sc.nextLine());
                return num;
            }catch(NumberFormatException e){
                System.out.println("Must be number.");
            }
        }
    }
    
    public Student inputStudent(){
        Student s = new Student();
        s.setName(checkString("Name"));
        s.setClasses(checkString("Class"));
        s.setMark(checkFloat());
        return s;
    }
    
    public void addStudent(){
        students.add(inputStudent());
    }
    
    boolean checkYN(){
        boolean check = true;
        while(true){
            System.out.println("Do you want to enter more student information?(Y/N): ");
            String c = sc.nextLine();
            if (c.equalsIgnoreCase("Y")){
                check = true;
                break;
            }else if (c.equalsIgnoreCase("N")){
                check = false;
                break;
            }else{
                System.out.println("valid choice.");
            }
        }
        
        return check;
    }
    
    public List<Student> sortStudent(){
        Collections.sort(students, new StudentComparator());
        return students;
    }
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
    
    public void display(){
        int i = 1;
        for (Student s: students){
            System.out.println("-----------Student "+i+"----------");
            System.out.println(s);
            i++;
        }
    }

    
}
