package amaon;

import java.util.Stack;

/**
 * Created by junm5 on 2/5/17.
 */
public class Add2Numers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carrier = 0;
        ListNode current = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num = carrier;
            if (!stack1.isEmpty()) {
                num += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                num += stack2.pop();
            }
            carrier = num / 10;
            ListNode p = new ListNode(num % 10);
            p.next = current;
            current = p;
        }
        if (carrier != 0) {
            ListNode p = new ListNode(carrier);
            p.next = current;
            current = p;
        }
        return current;
    }
}
