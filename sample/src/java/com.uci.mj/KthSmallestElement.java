package com.uci.mj;

import java.util.PriorityQueue;

/**
 * Created by junm5 on 10/9/16.
 */

public class KthSmallestElement {
    class Node implements Comparable<Node>{
        int i;
        int j;
        int val;
        Node(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
        public int compareTo(Node node){
            return this.val >= node.val ? 1 : -1;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for(int i = 0; i < matrix[0].length; i++){
            queue.offer(new Node(0, i, matrix[0][i]));
        }
        int count = 0;
        while(count < k){
            Node node = queue.poll();
            count ++;
            if(count == k){
                return node.val;
            }
            if((node.i + 1) < matrix.length){
                queue.offer(new Node(node.i+1, node.j, matrix[node.i + 1][node.j]));
            }
        }
        return -1;
    }
}
