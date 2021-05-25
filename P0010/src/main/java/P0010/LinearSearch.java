/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0010;

/**
 *
 * @author Admin
 */
public class LinearSearch {

    
    public static int linearSearch(int []arr, int value){
        boolean check = true;
        int i = 0;
        while(i  < arr.length && check == true){
            if(arr[i] == value){
                check = false;
                return i;
            }
            i++;
        }
        return -1;
    }
}
