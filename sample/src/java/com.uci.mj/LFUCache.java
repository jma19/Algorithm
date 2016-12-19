package com.uci.mj;


import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by junm5 on 11/24/16.
 */


public class LFUCache {


    private Map<Integer, Node> cache;
    private PriorityQueue<Node> priorityQueue;
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<Integer, Node>();
        this.priorityQueue = new PriorityQueue<Node>(capacity);
    }

    public int get(int key) {
        Node value = cache.get(key);
        if (value == null) {
            return -1;
        }
        value.fre++;
        value.timestamp = System.currentTimeMillis();
        return value.data;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            update(key, value);
        } else {
            if (cache.size() == capacity) {
                Node leastNode = priorityQueue.poll();
                int key1 = leastNode.key;
                cache.remove(key1);
                cache.put(key, getNode(key, value));
            } else {
                Node node = getNode(key, value);
                cache.put(key, node);
                priorityQueue.offer(node);
            }
        }
    }

    private void update(int key, int value) {
        Node node = cache.get(key);
        node.data = value;
        node.fre++;
        node.timestamp = System.currentTimeMillis();
    }

    private Node getNode(int key, int value) {
        Node node = new Node(key, value);
        node.fre = 1;
        node.timestamp = System.currentTimeMillis();
        return node;
    }

    private char transform(int val) {
        return (char) ('A' + (val - 1));
    }

    public static void main(String[] args) throws InterruptedException {


        PriorityQueue<Node> nodes = new PriorityQueue<Node>();
        Node node1 = new Node(1, 1);
        node1.fre = 2;
        Thread.sleep(1);
        node1.timestamp = System.currentTimeMillis();

        Node node2 = new Node(2, 2);
        node2.fre = 2;
        Thread.sleep(1);
        node2.timestamp = System.currentTimeMillis();
        Node node3 = new Node(3, 3);
        node3.fre = 1;
        Thread.sleep(1);

        node3.timestamp = System.currentTimeMillis();

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);


        Node poll1 = nodes.poll();
        System.out.println(poll1);
        Node poll2 = nodes.poll();
        System.out.println(poll2);
        Node poll3 = nodes.poll();
        System.out.println(poll3);


    }

    static class Node implements Comparable<Node> {
        int data;
        int key;
        int fre;
        long timestamp;

        Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public int compareTo(Node o) {
            if (this.fre < o.fre) {
                return -1;
            } else if (this.fre > o.fre) {
                return 1;
            } else {
                if (this.timestamp > o.timestamp) {
                    return 1;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", fre=" + fre +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}
