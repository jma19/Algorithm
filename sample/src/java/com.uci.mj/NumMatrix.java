package com.uci.mj;

import java.util.ArrayList;

public class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        dp[0][0] = matrix[0][0];
        
        for(int i = 1; i < matrix[0].length; i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for(int i = 1; i < matrix.length; i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                dp[i][j] = dp[i-1][j] +dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
            }
        }
    }
    public static void main(String[] args){
        NumMatrix numMatrix = new NumMatrix(new int[][]{{1,2,3}});
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.remove(Integer.valueOf(1));

        System.out.println(integers);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int row3 = row1 - 1;
        int col3 = col1 - 1;
        if(row3 < 0 && col3 > 0){
            return dp[row2][col2] - dp[row2][col3];
        } 
        if(row3 > 0 && col3 < 0){
            return dp[row3][col2] - dp[row3][col2];
        }
        if(row3 < 0 && col3 < 0){
            return dp[row2][col2];
        }
        return dp[row2][col2] - dp[row2][col3] - dp [row3][col2] + dp[row3][col3];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);