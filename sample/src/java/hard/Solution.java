package hard;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board[0].length) {
            List<String> temp = build(board);
            res.add(temp);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col + 1, res);
                board[i][col] = '.';
            }
        }
    }

    private List<String> build(char[][] board) {
        List<String> rs = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            rs.add(sb.toString());
        }
        return rs;
    }

    private boolean validate(char[][] board, int x, int y) {
        //left check
        for (int i = 0; i < y; i++) {
            if (board[x][i] == 'Q') {
                return false;
            }
        }
        //left up check
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //left down check
        for (int i = x + 1, j = y - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        coinChange(coins, 0, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void coinChange(int[] coins, int index, int amount, int temp){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            min = Math.min(min, temp);
        }
        for(int i = index; i < coins.length; i++){
            coinChange(coins, index, amount - coins[i], temp + 1);
        }
    }

    public static void main(String[] ars) {
        int i = new Solution().coinChange(new int[]{2, 3, 5}, 100);
        System.out.println(i);
    }


}