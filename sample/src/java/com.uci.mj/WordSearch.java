package com.uci.mj;

/**
 * Created by junm5 on 10/19/16.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for(int i = 0; i  < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(helper(board, new int[board.length][board[0].length], word, new StringBuffer(), i, j)){
                    return true;
                }
            }

        }
        return false;
    }

    boolean helper(char[][] board, int[][] visited, String target, StringBuffer temp, int row, int col) {

        if (target.equals(temp.toString())) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0
                || col >= board[0].length || visited[row][col] == 1
                || temp.length() > target.length()) {
            return false;
        }

        visited[row][col] = 1;
        temp.append(board[row][col]);

        System.out.println("row:"+row+ " col:"+ col + " "+ temp.toString());

        boolean res =
                helper(board, visited, target, temp, row + 1, col)
                        || helper(board, visited, target, temp, row - 1, col)
                        || helper(board, visited, target, temp, row, col + 1)
                        || helper(board, visited, target, temp, row, col - 1);
        visited[row][col] = 0;
        temp.deleteCharAt(temp.length() - 1);
        return res;

    }

    public static void main(String[] ags) {
        WordSearch wordSearch = new WordSearch();
        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}};
        boolean ba = wordSearch.exist(chars, "BA");

        System.out.println(ba);


    }
}
