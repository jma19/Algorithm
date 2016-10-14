package com.uci.mj;

/**
 * Created by junm5 on 10/10/16.
 */
public class LinkedListMergeSort {
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
        String str = "Iloveyou".toLowerCase();
        char[] chars = str.toCharArray();
        int [] ch = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ch[i] = chars[i] -'a' + 1;
        }
        for(int i : ch){
            System.out.print(i + " ");
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode sortList(ListNode head) {
            //merge sort and quick sort is nlogn

            if (head == null || head.next == null) {
                return head;
            }
            ListNode middle = findMiddle(head);  //O(n)
            ListNode secondHead = middle.next;
            middle.next = null;
            ListNode left = sortList(head);  //O(lgn)
            ListNode right = sortList(secondHead);

            return merge(left, right); //O(n)
        }

        private ListNode merge(ListNode ln1, ListNode ln2) {
            ListNode head = null;
            ListNode last = null;

            //current pointer for each list
            ListNode p = ln1, q = ln2;

            while (p != null && q != null) {
                //add p to the res
                while (p != null && q != null && (p.val < q.val)) {
                    if (head == null) {
                        head = p;
                        last = p;
                    } else {
                        last.next = p;
                        last = p;
                    }
                    p = p.next;
                }
                while (q != null && p != null && q.val < p.val) {
                    if (head == null) {
                        head = q;
                        last = q;
                    } else {
                        last.next = q;
                        last = q;
                    }
                    q = q.next;
                }
            }
            if (p == null) {
                while (q != null) {
                    last.next = q;
                    last = q;
                    q = q.next;
                }
            }
            if (q == null) {
                while (p != null) {
                    last.next = p;
                    last = p;
                    p = p.next;
                }
            }
            return head;
        }

        private ListNode findMiddle(ListNode head) {
            ListNode oneStep = head;
            ListNode twoStep = head;
            while (twoStep.next != null && twoStep.next.next != null) {
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
            }
            return oneStep;
        }
    }
}
