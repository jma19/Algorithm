package com.uci.mj;

import java.util.Stack;
import java.util.regex.Matcher;

/**
 * Created by junm5 on 12/14/16.
 */
public class largestRectangleArea {

    public int getLargestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack();
        int max = 0;
        int i = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }
        while (!stack.isEmpty()){
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h*w, max);

        }

        return max;
    }
}
