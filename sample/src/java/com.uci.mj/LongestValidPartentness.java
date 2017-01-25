package com.uci.mj;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by junm5 on 12/23/16.
 */
public class LongestValidPartentness {
    public int longestValidParentheses(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(' || stack.isEmpty()) {
                stack.push(i);
            } else {
                if (chs[stack.peek()] == '(') {
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        int max = 0;
        if (stack.isEmpty()) {
            return s.length();
        }
        //")()())()()("
        // 0    5    10
        int a = s.length(), b = 0;
        while (!stack.empty()) {
            b = stack.pop();
            max = Math.max(max, a - b - 1);
            a = b;
        }
        return Math.max(max, a);
    }
    public static void main(String[] args){
        LongestValidPartentness longestValidPartentness = new LongestValidPartentness();
        int i = longestValidPartentness.longestValidParentheses(")()())()()(");
        System.out.println(i);
        ArrayList<Integer> integers = new ArrayList<Integer>();
    }
}
