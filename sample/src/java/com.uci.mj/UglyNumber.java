package com.uci.mj;

import java.util.PriorityQueue;

/**
 * Created by junm5 on 10/5/16.
 */
public class UglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int result[] = new int[n];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        for (int i = 0; i < primes.length; i++) {
            priorityQueue.add(new Node(0, primes[i], primes[i]));
        }
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            Node peek = priorityQueue.peek();
            result[i] = peek.val;
            do {
                Node cul = priorityQueue.poll();
                cul.val = result[++cul.index] * cul.prime;
                priorityQueue.add(cul);
            } while (result[i] == priorityQueue.peek().val);
        }

        return result[n - 1];
    }

    public static void main(String [] arhs){
        UglyNumber uglyNumber = new UglyNumber();
        int[] primes = new int[]{2, 3, 7};
        uglyNumber.nthSuperUglyNumber(10, primes);
    }

    class Node implements Comparable<Node> {
        int index;
        int val;
        int prime;

        public Node(int index, int val, int prime) {
            this.index = index;
            this.val = val;
            this.prime = prime;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", val=" + val +
                    ", prime=" + prime +
                    '}';
        }

        public int compareTo(Node x) {
            return this.val > x.val ? 1 : -1;
        }
    }
}
