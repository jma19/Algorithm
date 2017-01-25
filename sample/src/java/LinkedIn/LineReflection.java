package LinkedIn;

import java.util.*;

/**
 * Created by junm5 on 12/29/16.
 */
public class LineReflection {

    public boolean isReflected(int[][] points) {
        //sort by the order of points[0], x -value
        if(points == null || points.length < 2){
            return true;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        double middleX = (points[0][0] + points[points.length-1][0])/2.0;

        int low = 0, high = points.length - 1;
        while(low <= high){
            if((points[low][0] + points[high][0])/2.0 != middleX){
                return false;
            }
            if(points[low][1] != points[high][1]){
                return false;
            }
            low++;
            high--;
            while(low <= high && points[low-1][0] == points[low][0] && points[low-1][1] == points[low][1]){
                low++;
            }
            while(low <= high && points[high+1][0] == points[high][0] && points[high + 1][1] == points[high][1]){
                high--;
            }
        }
        return true;
    }
    public static void main(String [] args){
        LineReflection lineReflection = new LineReflection();
        lineReflection.isReflected(new int[][]{});
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap();
    }
}
