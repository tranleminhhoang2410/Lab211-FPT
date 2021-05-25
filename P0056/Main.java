/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0056;

import P0063.PersonList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
static String code;
    static String name;
    static int age;
    static double salary;
    static String workLocation;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        WorkerList workerList = new WorkerList();
        int option = 0;
        while (option != 5) {
            menu();
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("--------- Add Worker ---------");
                    try {
                        System.out.println(workerList.addWorker(getWorker()) ? "Added!" : "Failed!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2, 3:
                    System.out.println("--------- Up/Down Salary ----------");
                    System.out.print("Enter code: ");
                    String code = input.next();
                    System.out.print("Enter Salary: ");
                    double amount = input.nextDouble();
                    Worker worker = workerList.getWorkerByCode(code);
                    SalaryStatus status = new SalaryStatus(amount, worker);
                    status.setStatus();
                    try {
                        System.out.println(workerList.changeSalary(status, code, amount) ? "Changed!" : "Failed!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("------------------- Display Information Salary -------------------");
                    System.out.printf("%8s %10s %12s %14s %16s %18s \n","Code","Name","Age","Salary","Status","Date");
                    workerList.printSalaryHistory(workerList.getInformationSalary());
                    break;
                default: System.out.println("Please enter 1 to 4");

            }
        }
    }

    public static void menu() {
        System.out.println("====== Worker Management ======");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.println("Your choice: ");
    }

    public static Worker getWorker() {
        System.out.print("Enter Code: ");
        code = input.next();
        System.out.print("Enter Name: ");
        name = input.next();
        System.out.print("Enter Age: ");
        age = input.nextInt();
        System.out.print("Enter Salary: ");
        salary = input.nextDouble();
        System.out.print("Enter work location: ");
        workLocation = input.next();
        return new Worker(code, name, age, salary, workLocation);
    }
}
