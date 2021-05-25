/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0050;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author M Hoang
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.println("Please choice an option: ");
    }
    
    public static void main(String[] args) {
        showMenu();
        int choice;
        float a, b, c;
        do {
            List<Float> list = new ArrayList<Float>();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    System.out.println("Enter A: ");
                    a = Equation.checkFloatInput();
                    System.out.println("Enter B: ");
                    b = Equation.checkFloatInput();
                    System.out.println("Solution: x = " + Equation.calculateEquation(a, b));
                    list.add(a);
                    list.add(b);
                    Equation.display(list);
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    System.out.println("Enter A: ");
                    a = Equation.checkFloatInput();
                    System.out.println("Enter B: ");
                    b = Equation.checkFloatInput();
                    System.out.println("Enter C: ");
                    c = Equation.checkFloatInput();
                    try{
                        int s = Equation.calculateQuadraticEquation(a, b, c).size();
                        if (s == 2){
                            System.out.println("Solution: x1 = " + Equation.calculateQuadraticEquation(a, b, c).get(0)
                                                  + " and x2 = " + Equation.calculateQuadraticEquation(a, b, c).get(1));
                        }else if(s==1){
                            System.out.println("Solution: x1 = " + Equation.calculateQuadraticEquation(a, b, c)
                                                  + " and x2 = " + Equation.calculateQuadraticEquation(a, b, c));
                        }else{
                            System.out.println("Solution: x = " + Equation.calculateQuadraticEquation(a, b, c));
                        }
                    }catch(Exception e){
                        System.out.println("Solution: " + Equation.calculateQuadraticEquation(a, b, c));
                    }
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    Equation.display(list);
                    break;
                case 3:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Option is not available !!");
            }
        } while (choice != 3);
    }
    
}
