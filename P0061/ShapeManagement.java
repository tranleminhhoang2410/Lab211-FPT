/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0061;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ShapeManagement {
    private Validate validate = new Validate();
    
    public Rectangle inputRectangle(){
        System.out.println("Please input width of Rectangle: ");
        double width = validate.checkInputDouble();    
        System.out.println("Please input length of Rectangle: ");
        while (true) {
            double length = validate.checkInputDouble();
            if(width > length){
                System.out.println("Width cannot be larger than length !!");
                System.out.println("Enter length again: ");
            }else{
                return new Rectangle(length, width);
            }
        }
    }
    
    public Circle inputCircle(){
        System.out.println("Please input radius of Circle: ");
        double radius = validate.checkInputDouble();
        return new Circle(radius);
    }
    
    public Triangle inputTriangle(){
        while (true) {
            System.out.println("Please input side A of Triangle: ");
            double a = validate.checkInputDouble();
            System.out.println("Please input side B of Triangle: ");
            double b = validate.checkInputDouble();
            System.out.println("Please input side C of Triangle: ");
            double c = validate.checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Total of 3 sides is not valid.");
                System.out.println("Input again");
            }
        }
    }
}
