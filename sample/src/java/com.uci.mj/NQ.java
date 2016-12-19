package com.uci.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 9/26/16.
 */
public class NQ {

    public static void main(String[] args){
        NQ nq = new NQ();
        List<List<String>> lists = nq.solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        solveNQUtil(board, 0);
        return list;
    }
    /* A recursive utility function to solve N Queen problem */
    public List<List<String>> list = new ArrayList();

    public void solveNQUtil(int board[][], int col) {
        /* base case: If all queens are placed*/
        if (col >= board.length) {
            list.add(copy(board));
        }
        /* Consider this column and try placing this queen in all rows one by one */
        for (int i = 0; i < board.length; i++) {
            /* Check if queen can be placed on
               board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
                /* recur to place rest of the queens */
                solveNQUtil(board, col + 1);
                board[i][col] = 0; // BACKTRACK
            }
        }
    }

    private List<String> copy(int[][] board) {
        List<String> list = new ArrayList<String>();
        for(int i =0; i < board.length; i++){
            String res = "";
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 0){
                    res +=".";
                }else{
                    res +="Q";
                }
            }
            list.add(res);
        }
        return list;
    }
    private boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
}
