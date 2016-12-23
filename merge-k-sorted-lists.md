#### 23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


~~~
  public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode o1,ListNode o2){
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode node : lists){
            if(node != null){
                pqueue.offer(node);
            }
        }
        while(!pqueue.isEmpty()){
            ListNode node = pqueue.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                pqueue.offer(node.next);
            }
        }
        return dummy.next;
    }
~~~


