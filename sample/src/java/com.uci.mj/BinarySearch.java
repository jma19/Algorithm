package com.uci.mj;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by junm5 on 10/7/16.
 */
public class BinarySearch {

    int binarySearch(int N, int[] A, int key, int start, int end) {
        if (start >= end) {
            return key >= A[start] ? (start + 1) : start;
        }
        int middle = (start + end) / 2;
        if (key < A[middle]) {
            return binarySearch(N, A, key, start, middle - 1);
        } else {
            return binarySearch(N, A, key, middle + 1, end);
        }
    }
//
    public static void main(String[] args){
        HashSet<Integer> integers = new HashSet<Integer>();

        System.out.println(Math.pow(2, 2.8));
        int[] data = {1};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearch(data.length, data, 0, 0, data.length - 1);
        System.out.println(i);
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<Integer, Integer>();
    }

}
