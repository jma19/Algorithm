###2. Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

**Example**
~~~
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
~~~

####Solution
~~~
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur1 = l1, pre = null;
        ListNode cur2 = l2;
        int carrier = 0, temp;
        while(cur1 != null && cur2 != null){
            temp = cur1.val + cur2.val + carrier;
            cur1.val  = temp  % 10;
            carrier  = temp  / 10;
            pre = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur2 != null){// cur1 == null
            temp = cur2.val + carrier;
            ListNode newNode = new ListNode(temp  % 10);
            pre.next = newNode;
            pre = newNode;
            carrier  = temp  / 10;
            cur2 = cur2.next;
        }
        while(cur1 != null){
            temp = cur1.val + carrier;
            cur1.val  = temp  % 10;
            carrier  = temp  / 10;
            pre = cur1;
            cur1 = cur1.next;
        }
        if(carrier != 0){
            pre.next = new ListNode(carrier);
        }
        return l1;
    }


