package facebook;

import java.util.Stack;

/**
 * Created by junm5 on 1/9/17.
 */
public class MiniParser {

    public NestedInteger deserialize(String s) {
        char[] chs = s.toCharArray();
        if (chs[0] != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack();
        int left = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '[') {
                stack.push(new NestedInteger());
                left = i + 1;
            } else if (chs[i] == ',') {
                if (chs[i - 1] != ']') {
                    //is digit number
                    stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(left, i))));
                }
                if (chs[i + 1] != '[') {
                    left = i + 1;
                }
            } else if (chs[i] == ']') {
                if (chs[i - 1] >= '0' && chs[i - 1] <= '9') {
                    stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(left, i))));
                }
                NestedInteger net = stack.pop();
                if (stack.isEmpty()) {
                    return net;
                } else {
                    stack.peek().add(net);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        String string = "?12?";
        System.out.println(string.indexOf('?'));
    }

}
