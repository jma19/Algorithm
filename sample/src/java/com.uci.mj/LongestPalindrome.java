package com.uci.mj;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by junm5 on 10/4/16.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            Integer val = map.get(ch[i]);
            if (val == null) {
                map.put(ch[i], 1);
            } else {
                map.put(ch[i], val + 1);
            }
        }

        Set<Character> keys = map.keySet();
        for (Character c : keys) {
            Integer val = map.get(c);
            if (max % 2 == 0) {
                max += val;
            } else {
                if (val % 2 == 0) {
                    max += val;
                } else {
                    max += val - 1;

                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(7);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode remove = remove(l1, 3);
        while (remove != null){
            System.out.println(remove.val);
            remove = remove.next;
        }
    }


    public static ListNode remove(ListNode head, int x) {
        ListNode fakeNode = new ListNode(-1), pre = fakeNode, cur = head;
        while (cur != null) {
            if (cur.val <= x) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return fakeNode.next;
    }


    static class ListNode {
        ListNode next;
        Integer val;

        ListNode(Integer val) {
            this.val = val;
        }
    }

}
