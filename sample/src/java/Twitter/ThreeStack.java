package Twitter;

/**
 * Created by junm5 on 6/29/17.
 */
public class ThreeStack {

    int stackSize = 300;
    int indexUsed = 0;
    //store the last index of stack node
    int[] stackPointer = {-1, -1, -1};
    StackNode[] buffer = new StackNode[stackSize * 3];

    public void push(int stackNum, int value) {
        int lastIndex = stackPointer[stackNum];
        StackNode stackNode = new StackNode(lastIndex, value);
        stackPointer[stackNum] = indexUsed;
        buffer[indexUsed++] = stackNode;
    }

    public int pop(int stackNum) {
        int index = stackPointer[stackNum];
        StackNode res = buffer[index];
        int previous = res.previous;
        stackPointer[stackNum] = previous;
        return res.value;
    }

    public int peek(int stackNum) {
        return buffer[stackPointer[stackNum]].value;
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    class StackNode {
        public int previous;
        public int value;

        public StackNode(int previous, int value) {
            this.previous = previous;
            this.value = value;
        }
    }
}
