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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShapeManagement shapeManagement = new ShapeManagement();
        System.out.println("=====Calculator Shape Program=====");
        Rectangle rectangle = shapeManagement.inputRectangle();
        Circle circle = shapeManagement.inputCircle();
        Triangle triangle = shapeManagement.inputTriangle();
        System.out.println("");
        System.out.println("-----Rectangle-----");
        rectangle.printResult();
        System.out.println("-----Circle-----");
        circle.printResult();
        System.out.println("-----Triangle-----");
        triangle.printResult();
    }
    
}
