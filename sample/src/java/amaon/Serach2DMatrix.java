package amaon;

import java.util.Random;

/**
 * Created by junm5 on 1/31/17.
 */
public class Serach2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        //binary search
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int row = mid / 4, col = mid % 4;
            System.out.println(row + " " + col);
            if(target == matrix[row][col]){
                return true;
            }
            else if(target > matrix[row][col]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Serach2DMatrix serach2DMatrix = new Serach2DMatrix();
        serach2DMatrix.searchMatrix(new int[][]{{1},{3}}, 2);
        Integer.highestOneBit(12);
        Random random = new Random();
        int i = random.nextInt(2);

    }
}
