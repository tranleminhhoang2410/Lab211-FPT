/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0006;

/**
 *
 * @author Admin
 */
public class BinarySearch {
    public static void bubbleSort(int []arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
    }
    
    
    public static int binarySearch(int []arr, int value, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(arr[mid] == value){
            return mid;
        }else if(arr[mid] > value){
            return binarySearch(arr, value, left, mid - 1);
        }else{
            return binarySearch(arr, value, mid + 1, right);
        }
    }
}
