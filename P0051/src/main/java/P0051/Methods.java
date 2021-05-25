/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0051;

import java.util.Scanner;

/**
 *
 * @author M Hoang
 */
public class Methods {
    private static final Scanner sc = new Scanner(System.in);
    public void showMenu(){
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.println("Please choice one option: ");
    }
    
    public double checkInputDouble(){
        while (true) {            
            try{
                double result = Double.parseDouble(sc.nextLine());
                return result;
            }catch(NumberFormatException e){
                System.out.println("Enter again !!");
            }
        }
    }
    
    public static Operator CheckOperator(String Op){
        
        Operator[] opArr = Operator.values();
        Operator a = null;
                
        for (int i=0; i < opArr.length; i++){
            if (Op.equals(opArr[i].value)){
                a = opArr[i];
            }
        }
        return a;
    }
     
    public void normalCalculator() {
        double memory;
        String operator;
        System.out.println("Enter number: ");
        memory = checkInputDouble();
        do{
            do{
                
                System.out.print("Enter Operator: ");
                operator = sc.nextLine().trim();
                if (CheckOperator(operator) == null){
                    System.out.println("Please input (+, -, *, /, ^)");
                }

            }while(CheckOperator(operator) == null);
            
            switch(CheckOperator(operator)){ 
                case plus:
                    memory += checkInputDouble();
                    System.out.println("Memory = "+ memory);
                    break;    
                case minus:
                    memory -= checkInputDouble();
                    System.out.println("Memory = "+ memory);
                    break;
                case multiply:
                    memory *= checkInputDouble();
                    System.out.println("Memory = "+ memory);
                    break;
                case divide:
                    double temp = memory / checkInputDouble();
                    try{
                        if(temp == Double.POSITIVE_INFINITY || temp == Double.NEGATIVE_INFINITY){
                            throw new ArithmeticException();
                        }else{
                            memory = temp;
                            System.out.println("Memory = "+ memory);
                        }
                    }catch(ArithmeticException e){
                        System.out.println("Can not divide by 0.");
                    }
                    break;
                case power:
                    memory =Math.pow(memory, checkInputDouble());
                    System.out.println("Memory = "+ memory);
                    break;
                case equal:
                    System.out.println("Result = "+ memory);
                    break;
            }
        }while(CheckOperator(operator) != Operator.equal);
    }
    
    public static BMI BMIStatus(double bmi){
        if (bmi < 19){
            return BMI.Under_Standard;
        }else if (bmi >= 19 && bmi < 25){
            return BMI.Standard;
        }else if (bmi >= 25 && bmi < 30){
            return BMI.Overweight;
        }else if (bmi >= 30 && bmi < 40){
            return BMI.Fat;
        }else{
            return BMI.VeryFat;
        }
    }
    
    public void BMICalculator(){
        System.out.println("Enter Weight(kg): ");
        double weight = checkInputDouble();
        System.out.println("Enter Height(cm): ");
        double height = checkInputDouble();
        double bmi = (weight / (height * height)) * 10000;
        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
