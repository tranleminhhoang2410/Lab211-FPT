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
public class Equation {
    private static final Scanner sc = new Scanner(System.in);
    
    public static float checkFloatInput(){
        while (true) {            
            try{
                float result = Float.parseFloat(sc.nextLine());
                return result;
            }catch(NumberFormatException e){
                System.out.println("Please input number");
            }
        }
    }
    
    public static boolean isEven(float number){
        if (number %2 ==0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isPerfectSquare(float Number){
        double d = Math.sqrt(Number);
        if (d == (int)d){
            return true;
        }else{
            return false;
        }
    }
    
    public static void display(List<Float> list){
        List<Float> evenList = new ArrayList<Float>();
        List<Float> oddList = new ArrayList<Float>();
        List<Float> perfectSquareList = new ArrayList<Float>();
        
        for(int i = 0; i < list.size(); i++){
            // add even, odd to list
            if(isEven(list.get(i))){
                evenList.add(list.get(i));
            }else{
                oddList.add(list.get(i));
            }
            
            // add perfect square to list
            if(isPerfectSquare(list.get(i))){
                perfectSquareList.add(list.get(i));
            }
        }
        System.out.println("Number is odd: " + oddList);
        System.out.println("Number is even: " + evenList);
        System.out.println("Number is perfect square: " + perfectSquareList);
    }
    
    public static List<Float> calculateEquation(float a, float b){
        List<Float> list = new ArrayList<Float>();
        if(a == 0 && b == 0){
            return list;
        }else if(a != 0){
            float x = -b / a;
            list.add(x);
            return list;
        }else{
            list.add(null);
        }
        return list;
    }
    
    public static List<Float> calculateQuadraticEquation(float a, float b, float c){
        List<Float> list = new ArrayList<Float>();
        if(a == 0){
            return calculateEquation(b, c);
        }else{
            float delta =  b * b - 4 * a * c;
            if(delta < 0){
                list.add(null);
                return list;
            }else if (delta == 0){
                float x = -b / (2 * a);
                list.add(x);
                return list;
            }else{
                float x1 = (float) ((- b + Math.sqrt(delta)) / (2 * a));
                float x2 = (float) ((- b - Math.sqrt(delta)) / (2 * a));
                list.add(x1);
                list.add(x2);
                return list;
            }
        }
    }
}
