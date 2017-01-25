package facebook;


/**
 * Created by junm5 on 1/8/17.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class LinkedRes {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode halfReverse = reverse(middle.next);
        middle.next = null;

        merge(head, halfReverse);

    }
    private ListNode findMiddle(ListNode head){
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;//1 -- 2 ---3
        while(fast != null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head, next = cur.next;
        while(cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(cur != null){
                next = cur.next;
            }
        }
        return pre;
    }
    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public static void main(String[] args) {
        LinkedRes linkedRes = new LinkedRes();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode middle = linkedRes.findMiddle(listNode1);
        System.out.println(middle);

        linkedRes.reorderList(listNode1);
    }
}
