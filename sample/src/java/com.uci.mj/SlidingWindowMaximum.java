package com.uci.mj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

/**
 * Created by junm5 on 10/9/16.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> queue = new LinkedList();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k){
                queue.poll();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                Integer poll = queue.peek();
                res[i - k + 1] = nums[poll];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int a : ints) {
            System.out.print(a + " ");
        }

        System.out.println();
        int[] ints1 = slidingWindowMaximum.maxSlidingWindow(new int[]{5, 4, 3, 2, 1, 0}, 3);
        for (int a : ints1) {
            System.out.print(a + " ");
        }


        System.out.println();
        int[] ints2 = slidingWindowMaximum.maxSlidingWindow(new int[]{5}, 1);
        for (int a : ints2) {
            System.out.print(a + " ");
        }

    }

}
