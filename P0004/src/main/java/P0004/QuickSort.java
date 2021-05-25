/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0004;

/**
 *
 * @author Admin
 */
public class QuickSort {
  
    
    public static int partition(int []arr, int left, int right){
        int pivot = arr[(left + right) / 2];
        
        while(left <= right){
            while(arr[left] < pivot){
                left++;
            }
            while(arr[right] > pivot){
                right--;
            }
            if(left <= right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            }
        }
        return left;
    }
    
    public static void quickSort(int []arr, int left, int right){
        int index = partition(arr, left, right);
        if(left < index - 1){
            quickSort(arr, left, index - 1);
        }
        if(index < right){
            quickSort(arr, index, right);
        }
    }
}
