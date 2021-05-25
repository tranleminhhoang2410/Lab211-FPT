/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DoctorHash {
    private HashMap<String, Doctor> hashMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    CheckInput checkInput = new CheckInput();

    public void showMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("1. Add Doctor.");
        System.out.println("2. Update Doctor.");
        System.out.println("3. Delete Doctor.");
        System.out.println("4. Search Doctor.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option: ");
    }

    public void add() {
        Doctor d = new Doctor();
        System.out.println("--------- Add Doctor ----------");
        System.out.println("Enter Code: ");
        d.setCode(checkInput.checkInputEmpty());
        System.out.println("Enter Name: ");
        d.setName(checkInput.checkInputEmpty());
        System.out.println("Enter Specialization: ");
        d.setSpecialization(checkInput.checkInputEmpty());
        System.out.println("Enter Availability: ");
        d.setAvailability(checkInput.checkInputInt());
        try {
            addDoctor(d);
            hashMap.put(d.getCode(), d);
            System.out.println("Doctor add successfully!");
        } catch (DoctorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean addDoctor(Doctor d) throws DoctorException {
        if (d == null) {
            throw new DoctorException("Database does not exist!");
        }
        if (hashMap.containsKey(d.getCode())) {
            throw new DoctorException("Doctor code '" + d.getCode() + "' is duplicate!");
        }
        if (d.getCode().equals("")) {
            throw new DoctorException("Data does not exist!");
        }
        return true;
    }

    public void update() {
        System.out.println("--------- Update Doctor ----------");
        if (hashMap.isEmpty()) {
            try {
                throw new DoctorException("Database does not exist!\n");
            } catch (DoctorException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Enter code to modify: ");
            String codeModify = checkInput.checkInputEmpty();
            if (!hashMap.containsKey(codeModify)) {
                try {
                    throw new DoctorException("Doctor code does not exist!\n");
                } catch (DoctorException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("Enter Name: ");
                hashMap.get(codeModify).setName(checkInput.checkInputEmpty());
                System.out.println("Enter Specialization: ");
                hashMap.get(codeModify).setSpecialization(checkInput.checkInputEmpty());
                System.out.println("Enter Availability: ");
                hashMap.get(codeModify).setAvailability(checkInput.checkInputInt());
            }
        }
    }

    public void delete() {
        System.out.println("--------- Delete Doctor ----------");
        if (hashMap.isEmpty()) {
            try {
                throw new DoctorException("Database does not exist!\n");
            } catch (DoctorException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Enter code to delete: ");
            String codeDelete = checkInput.checkInputEmpty();
            if (!hashMap.containsKey(codeDelete)) {
                try {
                    throw new DoctorException("Doctor code does not exist!\n");
                } catch (DoctorException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                hashMap.remove(codeDelete);
            }
        }
    }

    public void search() {
        System.out.println("--------- Search Doctor ----------");
        if (hashMap.isEmpty()) {
            try {
                throw new DoctorException("Database does not exist!\n");
            } catch (DoctorException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Enter code to search: ");
            String codeSearch = checkInput.checkInputEmpty();
            if (!hashMap.containsKey(codeSearch)) {
                try {
                    throw new DoctorException("Doctor code does not exist!\n");
                } catch (DoctorException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println(hashMap.get(codeSearch) + "\n");
            }
        }
    }

    public void display() {
        System.out.println("---------Result---------");
        Collection value = hashMap.values();
        Iterator itr = value.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("");
    }
 
}
