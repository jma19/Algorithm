package LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 12/27/16.
 * 311. Sparse Matrix Multiplication
 */
public class SparseMatrixMultiplication {
    /**
     * A = [
     * [ 1, 0, 0],
     * [-1, 0, 3]
     * ]
     * <p>
     * B = [
     * [ 7, 0, 0 ],
     * [ 0, 0, 0 ],
     * [ 0, 0, 1 ]
     * ]
     * <p>
     * <p>
     * |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
     * | 0 0 1 |
     */

    public int[][] multiply1(int[][] A, int[][] B) {
        //brute force
        int m = A.length, n = B[0].length, nB = B[0].length;
        int[][] res = new int[m][n];


        return res;
    }


}
