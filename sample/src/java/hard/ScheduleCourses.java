package hard;

import java.util.*;

/**
 * Created by junm5 on 11/15/17.
 */
public class ScheduleCourses {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        int[] inLinks = new int[numCourses];
        for (int[] pre : prerequisites) {
            adjList[pre[1]].add(pre[0]);
            inLinks[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (inLinks[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int cou = queue.poll();
            result[count++] = cou;
            for (Integer to : adjList[cou]) {
                inLinks[to]--;
                if (inLinks[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        ScheduleCourses scheduleCourses = new ScheduleCourses();
        int[] order = scheduleCourses.findOrder(2, new int[][]{{1, 0}});
        System.out.println(order);
    }

}
