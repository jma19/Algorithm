package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by junm5 on 6/24/17.
 */
public class SetOfStacks {

    private int capacity;
    private List<Stack<Integer>> stackList = new ArrayList();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    private Stack<Integer> getLastStack() {
        if (stackList.isEmpty()) {
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    public void push(int value) {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null || lastStack.size() == capacity) {
            lastStack = new Stack<>();
            stackList.add(lastStack);
        }
        lastStack.push(value);
    }

    public int pop() {
        Stack<Integer> lastStack = getLastStack();
        int v = lastStack.pop();
        if (lastStack.isEmpty()) {
            stackList.remove(stackList.size() - 1);
        }
        return v;
    }

    public int popAt(int index) {
        Stack<Integer> stack = stackList.get(index);
        int res = stack.pop();
        if (index != stackList.size() - 1) {
            index++;
            Stack<Integer> temp = stackList.get(index);
            Integer remove = temp.remove(0);
            stack.push(remove);
        }
        if (stack.isEmpty()) {
            stackList.remove(stackList.size() - 1);
        }
        return res;

    }
}
