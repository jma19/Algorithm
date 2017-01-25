package amaon;

/**
 * Created by junm5 on 1/19/17.
 */
public class ReverseHalfLinkedList {
    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode fast = dumpy, slow = dumpy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode cur = ReverseHalfLinkedList.reverseSecondHalfList(listNode);
        while (cur != null) {
            System.out.println(cur.val + " ");
            cur = cur.next;

        }

    }

}

class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}
