package LinkedIn;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by junm5 on 12/29/16.
 */
public class MaxPoints {
    public int maxPoints(Point[] points) {

        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        Map<Double, Integer> map = new HashMap();
        int len = points.length, max = 0;
        for (int i = 0; i < len; i++) {
            int duplicate = 0, verticle = 0;
            for (int j = i + 1; j < len; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;

                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                if (x == 0) {
                    verticle++;
                    continue;
                }
                double scope = y / (x * 1.0) == 0 ? 0 : y / (x * 1.0);
                map.put(scope, map.getOrDefault(scope, 1) + 1);
            }
            for (Integer value : map.values()) {
                if ((duplicate + value) > max) {
                    max = duplicate + value;
                }
            }
            max = Math.max(max, duplicate + verticle);
            map.clear();
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.highestOneBit(3));
//        MaxPoints maxPoints = new MaxPoints();
//        System.out.println(maxPoints.maxPoints(new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)}));
//
//        int[][] test = {{3, 3}, {1, 1}, {0, 0}};
//        Arrays.sort(test, new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        for(int i = 0; i < test.length ; i++){
//            for(int j = 0; j < test[0].length; j++){
//                System.out.print(test[i][j] + ",");
//            }
//            System.out.println();
//        }
//        PriorityQueue priorityQueue = new PriorityQueue(new Comparator() {
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });
        Queue<Integer> queue  = new LinkedList();
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
    }
}