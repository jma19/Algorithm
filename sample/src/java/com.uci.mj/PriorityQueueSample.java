package com.uci.mj;

import java.util.PriorityQueue;


/**
 * Created by junm5 on 10/5/16.
 */
public class PriorityQueueSample {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                pq.add(current.val);
            }
        }
        if (pq.peek() == null) {
            return null;
        }
        ListNode head = new ListNode(pq.poll());
        ListNode current = head;
        while (!pq.isEmpty()) {

            ListNode temp = new ListNode(pq.poll());
            current.next = temp;
            current = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        PriorityQueueSample priorityQueueSample = new PriorityQueueSample();
        ListNode[]  listNodes = new ListNode[1];
        listNodes[0] = new ListNode(1);
        ListNode listNode = priorityQueueSample.mergeKLists(listNodes);
        System.out.println(listNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
