/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0068;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        StudentComparator studentComparator = new StudentComparator();
        boolean check = true;
        while(check){
            studentComparator.addStudent();
            check = studentComparator.checkYN();
        }
        studentComparator.sortStudent();
        studentComparator.display();
    }        
    
}
