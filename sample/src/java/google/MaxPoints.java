package google;

import LinkedIn.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 5/3/18.
 */
public class MaxPoints {
    public int maxPoints(Point[] points) {
        Map<Double, Integer> scop = new HashMap();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            scop.clear();
            int tempMax = 0;
            int same = 0;
            int vert = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;

                if (dx == 0 && dy == 0) {
                    same++;
                    continue;
                }
                if (dx == 0) {
                    vert++;
                    continue;
                }
                double k = dy == 0 ? 0 :
                        dy * 1.0 / dx;
                int value = scop.getOrDefault(k, 0) + 1;
                if (value > tempMax) {
                    tempMax = value;
                }
                scop.put(k, value);
            }
            System.out.println(same);
            result = Math.max(result, tempMax + same + vert + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        Point[] points = {
                new Point(-5, 3), new Point(1, 3), new Point(2, 3)

        };
        int i = maxPoints.maxPoints(points);
        System.out.println(i);
    }


}
