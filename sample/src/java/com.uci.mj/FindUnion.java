package com.uci.mj;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by junm5 on 11/16/16.
 */
public class FindUnion {
    private Map<Integer, Node> map = new HashMap();

    class Node {
        int rank;
        int data;
        Node parent;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return data == node.data;

        }

        @Override
        public int hashCode() {
            return data;
        }
    }


    public void makeSet(Integer value) {
        Node node = new Node();
        node.rank = 0;
        node.data = value;
        node.parent = node;
        map.put(value, node);
    }

    public void union(Integer data1, Integer data2) {
        Node parent1 = findSet(data1);
        Node parent2 = findSet(data2);

        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }

    }

    public Node findSet(Integer val) {
        return findSet(map.get(val));
    }

    //find representative node, path compression
    public Node findSet(Node node) {
        if (node.parent == node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String[] args) {
        FindUnion findUnion = new FindUnion();
        for (int i = 1; i < 6; i++) {
            findUnion.makeSet(i);
        }
        findUnion.union(1, 2);
        findUnion.union(3, 4);
        findUnion.union(4, 5);
        findUnion.union(1, 5);

        HashSet<Node> integers = new HashSet<Node>();
        for (int i = 0 ; i < 5; i++) {
            integers.add(findUnion.findSet(i + 1));
        }
        System.out.println(integers.size());

    }

}
