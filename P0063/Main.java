/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0063;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonList pList = new PersonList();
        pList.addPerson();
        pList.sortPerson();
        pList.displayPersonInfo();
    }
    
}
