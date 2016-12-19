package com.uci.mj;

/**
 * Created by junm5 on 10/10/16.
 */
public class InsertionSortList {
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

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);

        listNode1.next = listNode2;
        System.out.println(listNode1);
        ListNode secondHead = listNode1;
        secondHead.next = null;
        System.out.println(listNode1);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secondHead = head;
        secondHead.next = null;
        ListNode current = head.next;
        while (current != null) {
            ///find the insertion place
            //add to head
            ListNode currentNext = current.next;
            if (secondHead.val >= current.val) {
                current.next = secondHead;
                secondHead = current;
            }
            ListNode secondCurrent = secondHead;
            ListNode parrent = secondHead;
            //add to the middle
            while (secondCurrent != null && secondCurrent.val < current.val) {
                parrent = secondCurrent;
                secondCurrent = secondCurrent.next;
            }
            //add to the middle
            if (secondCurrent != null) {
                parrent.next = current;
                current.next = secondCurrent;
            }
            //add to the last
            else {
                parrent.next = current;
                current.next = null;
            }
            current = currentNext;
        }
        return secondHead;
    }
}
