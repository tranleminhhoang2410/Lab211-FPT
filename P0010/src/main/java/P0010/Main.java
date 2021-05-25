/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0010;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        int n = sc.nextInt();
        System.out.println("Enter search value: ");
        int value = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = -(2*n) + (int)(Math.random() * ((2*n - (-2*n)) + 1));
        }
        System.out.print("The array: " + Arrays.toString(arr));
        System.out.println();
        System.out.print("Found " + value + " at index: " + LinearSearch.linearSearch(arr, value));
    }
    
}
