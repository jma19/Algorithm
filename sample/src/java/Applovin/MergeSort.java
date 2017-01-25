package Applovin;

import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by junm5 on 1/16/17.
 */
public class MergeSort {

    public void mergeSort(Comparable[] data, Comparable[] temp, int left, int right) {
        if(left < right){
            int middle = (left + right )/2;
            mergeSort(data, temp, left, middle - 1);
            mergeSort(data, temp, middle, right);
            merge(data, temp, left, middle, right);
        }
    }


    private void merge(Comparable[] data, Comparable[] temp, int left, int right, int rightEnd){
    }
}

class Employee implements Comparable<Employee> {

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
