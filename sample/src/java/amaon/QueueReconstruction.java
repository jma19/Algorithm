package amaon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junm5 on 4/18/17.
 */
public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> temp = new ArrayList<>();
        for (int[] ele : people) {
            temp.add(ele[1], ele);
        }
        return temp.toArray(people);
    }
}
