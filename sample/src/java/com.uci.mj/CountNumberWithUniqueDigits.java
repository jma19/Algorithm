package com.uci.mj;

/**
 * Created by junm5 on 9/22/16.
 */
public class CountNumberWithUniqueDigits {

    void print(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("invalid input");
            return;
        }
        int i = 0;
        for (; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[i] + ".");
    }
    public static void main(String[] args){
        int[] a = null;
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

}
