package hard;

import java.util.ArrayList;

/**
 * Created by junm5 on 9/26/17.
 */
public class NumArray {
    private int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[i + 1] - dp[j];
    }

    public static void main(String[] at) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, 1});
        numArray.sumRange(0, 2);
    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArclass Solution {
 public List<List<String>> solveNQueens(int n) {
 char[][] board = new char[n][n];
 for(int i = 0; i < board.length; i++){
 for(int j = 0; j < board[0].length; j++){
 board[i][j] = '.';
 }
 }
 List<List<String>> res = new ArrayList();
 dfs(board, 0, res);
 return res;
 }
 private void dfs(char[][] board, int col, List<List<String>> res){
 if(col == board[0].length){
 List<String> temp = build(board);
 res.add(temp);
 return;
 }
 for(int i = 0; i < board.length; i++){
 if(validate(board, i, col)){
 board[i][col] = 'Q';
 dfs(board, col + 1, res);
 board[i][col] = '.';
 }
 }
 }
 private List<String> build(char[][] board){
 List<String> rs = new ArrayList();
 for(int i = 0; i < board.length; i++){
 StringBuffer sb = new StringBuffer();
 for(int j = 0; j < board[0].length; j++){
 sb.append(board[i][j]);
 }
 rs.add(sb.toString());
 }
 return rs;
 }
 private boolean validate(char[][] board, int x, int y){
 //left check
 for(int i = 0; i < y; i++){
 if(board[x][i] == 'Q'){
 return false;
 }
 }
 //left up check
 for(int i = x -1; i >=0; i--){
 for(int j = y - 1; j >=0; j--){
 if(board[i][j] == 'Q'){
 return false;
 }
 }
 }
 //left down check
 for(int i = x + 1; i < board.length; i++){
 for(int j = y - 1; j >=0; j--){
 if(board[i][j] == 'Q'){
 return false;
 }
 }
 }
 return true;
 }



 }ray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
