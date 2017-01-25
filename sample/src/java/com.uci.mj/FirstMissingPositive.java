package com.uci.mj;

/**
 * Created by junm5 on 12/22/16.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) {
                System.out.println("A[i] - 1 = "+ (A[i] - 1) + " i = " + i);
                swap(A, i, A[i]-1);
                print(A);
                System.out.println();
            }
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    void print(int[] A){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + ",");
        }
    }
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void main(String [] args){
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

        firstMissingPositive.firstMissingPositive(new int[]{1,2,6,7,3,5});

    }

}
