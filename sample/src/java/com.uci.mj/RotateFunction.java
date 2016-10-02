package com.uci.mj;

/**
 * Created by junm5 on 10/1/16.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int max = -2147483648;
        for(int i = 0; i < A.length; i++){
            int temp = 0;
            for(int j = 1; j < A.length; j ++){
                temp += j*A[(i + j) % A.length];
            }
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }
    public static void main(String [] arsg){
        RotateFunction rotateFunction = new RotateFunction();
        int [] A = new int[]{4,3,2,6};
        int i = rotateFunction.maxRotateFunction(A);
        System.out.println(i);
        String str = "";
    }

}
