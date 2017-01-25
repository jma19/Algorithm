package amaon;

import java.util.Stack;

/**
 * Created by junm5 on 1/19/17.
 */
public class ParenthesesCounter {
    /**
     * 给你一个str,里面只有 '('和‘)’,让你数valid pairs一共有多少,如果不是valid就返回-1.
     * (判断是不是valid的parenthesis string，不是的话返回-1，是的话返回valid pair个数，即String.length() / 2 )
     *
     * @param s
     * @return
     */
    public int ValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty() ? s.length() / 2 : -1;
    }

    public static void main(String[] args) {
        System.out.println(')' - '(');
    }
}
