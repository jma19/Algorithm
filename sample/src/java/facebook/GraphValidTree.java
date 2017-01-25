package facebook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by junm5 on 1/10/17.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        //use dfs or bfs to solve this problem
        ArrayList[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        //no direction
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(adj, -1, 0, visited)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(ArrayList[] adj, int parent, int curr, boolean[] visited) {
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;
        ArrayList<Integer> arrayList = adj[curr];
        for (Integer v : arrayList) {
            if (v != parent && hasCycle(adj, curr, v, visited)) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        graphValidTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
    }
}
