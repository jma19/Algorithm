package com.uci.mj;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by junm5 on 9/25/16.
 */
public class DecodeString {
    final String dights = "0123456789";

    public String decodeString(String s) {
        //using stack to solve this probem
        if (s == null || "".equals(s)) {
            return s;
        }
        char[] chs = s.toCharArray();
        Stack<String> stack = new Stack();
        int index = 1;
        stack.push("" + chs[0]);
        while (index < chs.length) {
            if (chs[index] != ']') {
                stack.push("" + chs[index]);
                index++;
            } else {
                String temp = "";
                while (!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop(); //pop '['

                String num = "";
                while (!stack.isEmpty() && dights.contains(stack.peek())) {
                    num = stack.pop() + num;
                }
                Integer numValue = Integer.parseInt(num);

                String res = "";
                for (int i = 0; i < numValue; i++) {
                    res = res + temp;
                }
                stack.push(res);
                index++;
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
//        DecodeString decodeString = new DecodeString();
//        String s = decodeString.decodeString("100[leetcode]");
//        System.out.println(s);
        String s = "abc";
        System.out.println(s.substring(3).equals(""));
    }
}

