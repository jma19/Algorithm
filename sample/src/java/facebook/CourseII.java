package facebook;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by junm5 on 1/10/17.
 */
public class CourseII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean visited[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < numCourses; i++) {
            if (!topologySort(adj, i, stack, visited, new boolean[numCourses])) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    private boolean topologySort(ArrayList<Integer>[] adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (isLoop[v]) {
            return false;
        }
        if (visited[v]) {
            return true;
        }

        isLoop[v] = true;
        visited[v] = true;

        for (Integer i : adj[v]) {
            if (!topologySort(adj, i, stack, visited, isLoop)) {
                return false;
            }
        }

        stack.push(v);
        isLoop[v] = false;
        return true;
    }

    public static void main(String[] args) {
        CourseII courseII = new CourseII();
        int[] order = courseII.findOrder(2, new int[][]{{0, 1}, {1, 0}});
        for (int i = 0; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }

    class Node implements Comparable<Node> {
        int vlaue;
        int index;

        @Override
        public int compareTo(Node o) {
            return this.vlaue - o.vlaue;
        }
    }
}
