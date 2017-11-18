package Twitter;

import java.util.Stack;

/**
 * Created by junm5 on 6/29/17.
 */
public class MinStack {
    //How would you design a stack which,
    // in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.

    //we can use two stack to implement minstack
    //one is for store min value, and another is for a
    private Stack<Integer> min = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public void push(int value) {
        stack.push(value);
        if (value < min.peek()) {
            min.push(value);
        }
    }

    public int min() {
        return min.peek();
    }

    public int pop() {
        int res = stack.pop();
        if (res == min.peek()) {
            min.pop();
        }
        return res;
    }

}
