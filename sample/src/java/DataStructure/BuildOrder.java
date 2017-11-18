package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junm5 on 7/9/17.
 */
public class BuildOrder {

    public static List<Node> getBuildOrder(Graph graph) {
        Map<Node, List<Node>> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        for (Node node : graph.nodes) {
            map.put(node, node.children);
            if (node.children.size() == 1) {
                list.add(node);
            }
        }
        List<Node> res = new ArrayList<>();

        while (!list.isEmpty()) {
            List<Node> temp = new ArrayList<>();
            for (Node node : list) {
                List<Node> nodeWithOneChild = map.get(node);
                Node neighbor = nodeWithOneChild.get(0);
                List<Node> neigList = map.get(neighbor);
                neigList.remove(node);
                res.add(node);
                map.remove(node);
                if (neigList.size() == 1) {
                    temp.add(neighbor);
                }
            }
            list = temp;
        }
        return res;
    }

    class Graph {
        List<Node> nodes;
    }

    class Node {
        int val;
        List<Node> children;
    }
}
