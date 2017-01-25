package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junm5 on 1/8/17.
 */
public class NumberIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] rootArray = new int[m * n];
        Arrays.fill(rootArray, -1);

        ArrayList<Integer> result = new ArrayList<Integer>();

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;

        for (int k = 0; k < positions.length; k++) {
            count++;
            int[] p = positions[k];
            int index = p[0] * n + p[1];
            rootArray[index] = index;//set root to be itself for each nod

            for (int r = 0; r < 4; r++) {
                int i = p[0] + directions[r][0];
                int j = p[1] + directions[r][1];

                if (i >= 0 && j >= 0 && i < m && j < n && rootArray[i * n + j] != -1) {
                    //get neighbor's root
                    int thisRoot = getRoot(rootArray, i * n + j);
                    if (thisRoot != index) {
                        rootArray[thisRoot] = index;//set previous root's root
                        count--;
                    }
                }
            }

            result.add(count);
        }
        return result;

    }
    public static void main(String[] args){
        NumberIslandsII numberIslandsII = new NumberIslandsII();
        numberIslandsII.numIslands2(2,2, new int[][]{{1,1},{1,0}});
    }

    private int getRoot(int[] rootArray, int i) {
        while (rootArray[i] != i) {
            i = rootArray[i];
        }
        return i;
    }

}
