/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0063;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class PersonList {
    private final ArrayList<Person> personList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    
    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }
    
    public double checkInputDouble(){
        while(true){
            try{
                System.out.println("Enter Salary: ");
                double salary = Double.parseDouble(sc.nextLine());
                
                if(salary<0){
                    throw new NumberFormatException();
                }else{
                    return salary;
                }
                
            }catch(NumberFormatException e){
                System.out.println("Salary must be number larger than 0.");
            }
        }
    }
    
    public Person inputPersonInfo(){
        Person p = new Person();
        System.out.println("Enter name: ");
        p.setName(checkInputString());
        System.out.println("Enter address: ");
        p.setAddress(checkInputString());
        p.setSalary(checkInputDouble());
        return p;
    }
    
    public void addPerson(){
        for(int i = 0; i < 3; i++){
            System.out.println("Input Information of Person: ");
            personList.add(inputPersonInfo());
            System.out.println("----------------------------");
        }
    }
    
    public int compareTo(Person p1, Person p2){
        int result = 0;
        if(p1.getSalary() < p2.getSalary()){
            result = -1;
        }
        if(p2.getSalary() < p1.getSalary()){
            result = 1;
        }
        return result;
    }
    public List<Person> sortPerson(){
        Person t;
        for(int i = 0; i < personList.size() - 1; i++){                
            if(compareTo(personList.get(i), personList.get(i+1))==1){
                    t = personList.get(i);
                    personList.set(i, personList.get(i + 1));
                    personList.set(i + 1, personList.get(i));
            }
            
        }
        return personList;
    }
    public void displayPersonInfo(){
        for(Person p: personList){
            System.out.println("--------------------------");
            System.out.println(p.toString());
        }
    }
    
   
    
}
