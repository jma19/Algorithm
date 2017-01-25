package Applovin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by junm5 on 1/16/17.
 */
public class QuickSort {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public void quickSort(int data[], int start, int end){
        if (start <= end){
            int pivot = partion(data, start, end);
            quickSort(data, pivot + 1, end);
            quickSort(data, start, pivot - 1);
        }
    }

    private int partion(int data[], int start, int end){
        int pivot = data[start];
        int i = start;
        for(int j = start + 1; j <= end; j++){
            if(data[j] < pivot){
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i, start);
        return i;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {1,3,2,6,3,46,2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
