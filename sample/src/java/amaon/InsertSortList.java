package amaon;

/**
 * Created by junm5 on 11/22/17.
 */
public class InsertSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode numby = new ListNode(0);
        ListNode curr = head;
        while(curr != null){
            //find the position to insert
            ListNode next = curr.next;
            ListNode pre = numby, insertPos = numby.next;
            while(insertPos != null && curr.val > insertPos.val){
                pre = insertPos;
                insertPos = insertPos.next;
            }
            pre.next = curr;
            curr.next = insertPos;
            curr = next;
        }
        return numby.next;
    }
    public static void main(String[] args){
        InsertSortList insertSortList = new InsertSortList();

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        head.next = second;
        ListNode listNode = insertSortList.insertionSortList(head);
        System.out.println(listNode);
    }

}
