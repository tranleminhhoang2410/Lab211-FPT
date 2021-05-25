/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0053;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Methods {
    private static final Scanner sc = new Scanner(System.in);
    public void showMenu(){
        System.out.println("========= Bubble Sort program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
        System.out.println("Please choice one option: ");
    }
    
    public int checkInputInt(){
        while (true) {            
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            }catch(NumberFormatException e){
                System.out.println("Input again");
            }
        }
    }
    
    public int inputSize(){
        System.out.println("Input Length Of Arrays");
        System.out.println("Enter Number: ");
        while (true) {            
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result <= 0){
                    throw new NumberFormatException();
                }
                return result;
            }catch (NumberFormatException e){
                System.out.println("Please input number greater than zero.");
                System.out.println("Enter Number: ");
            }
        }
    }
    
    public int[] inputElement(){
        int n = inputSize();
        int []arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter number " + (i + 1) + ": ");
            arr[i] = checkInputInt();
        }
        return arr;
    }
    
    public void sortAscending(int []arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1){
                System.out.print("[" + arr[i] + "]");
                break;
            }
            System.out.print("[" + arr[i] + "]->");
        }
        System.out.println();
    }
    
    public void sortDscending(int []arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] > arr[j - 1]){
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1){
                System.out.print("[" + arr[i] + "]");
                break;
            }
            System.out.print("[" + arr[i] + "]<-");
        }
        System.out.println();
    }
}
