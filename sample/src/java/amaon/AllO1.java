package amaon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by junm5 on 2/6/17.
 */

public class AllO1 {


    private Map<String, Node> map;
    private Node head, tail;

    /**
     * Initialize your data structure here.
     */
    public AllO1() {
        map = new HashMap();
        head = null;
        tail = null;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            //add newNode to the tail
            Node newNode = new Node(1);

            newNode.keys.add(key);
            if (tail == null) {
                tail = newNode;
                head = newNode;

            }
            //merge with the tail value
            else if (tail.val == newNode.val) {
                tail.keys.add(key);
            } else {
                //add node the tail
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
            //map new key to the tail
            map.put(key, tail);

        } else {
            Node node = map.get(key);
            node.keys.remove(key);
            Node newNode = new Node(node.val + 1);

            //increase to head
            if (node.pre == null) {
                head = newNode;
                head.keys.add(key);
                head.next = node;
                node.pre = head;
            } else {
                //merge with previous node
                if (node.pre.val == newNode.val) {
                    node.pre.keys.add(key);
                } else {
                    //insert into a newNode
                    newNode.keys.add(key);
                    node.pre.next = newNode;
                    newNode.pre = node.pre;
                    node.pre = newNode;
                    newNode.next = node;
                }

            }
            map.put(key, node.pre);
            if (node.keys.size() == 0) {
                node.pre.next = node.next;
                if (node.next != null) {
                    node.next.pre = node.pre;
                } else {
                    tail = node.pre;
                    node.pre = null;
                }
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {

        Node node = map.get(key);
        if (node == null) {
            return;
        }
        node.keys.remove(key);

        if (node.val == 1) {
            //delete key from map
            map.remove(key);
            if(node.keys.size() == 0) {
                tail = node.pre;
            }
            return;
        } else {
            if (node.next != null) {
                //merge with next node
                if (node.val - 1 == node.next.val) {
                    System.out.println(node.next.keys.size());

                    node.next.keys.add(key);
                    node.next.pre = node.pre;

                    if(node.pre != null){
                        node.pre.next = node.next;
                    }else{
                        head = node.next;
                    }
                    map.put(key, node.next);
                    return;
                } else {
                    Node newNode = new Node(node.val - 1);
                    newNode.keys.add(key);
                    newNode.next = node.next;
                    newNode.pre = node;
                    node.next.pre = newNode;
                    node.next = newNode;
                }
            } else {
                //create new node
                Node newNode = new Node(node.val - 1);
                newNode.keys.add(key);
                newNode.pre = node;
                node.next = newNode;
                tail = newNode;
            }
            map.put(key, node.next);
        }
        //remove node
        if (node.keys.size() == 0) {
            if (node.pre != null) {
                node.pre.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
        }

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (head == null) {
            return "";
        }
        for (String value : head.keys) {
            return value;
        }
        return "";
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (tail == null) {
            return "";
        }
        for (String value : tail.keys) {
            return value;
        }
        return "";
    }

    public static void main(String[] args) {
        AllO1 allO1 = new AllO1();
        allO1.inc("hello");
        allO1.inc("world");
        allO1.inc("hello");
        allO1.dec("world");

        allO1.inc("hello");
        allO1.inc("leet");
        System.out.println(allO1.getMaxKey());

        allO1.dec("hello");
        allO1.dec("hello");
        allO1.dec("hello");
        System.out.println(allO1.getMaxKey());


//        System.out.println(allO1.getMaxKey());
//        System.out.println(allO1.getMinKey());
//        allO1.dec("C");


    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}

class Node {
    Node pre;
    Node next;
    int val;
    Set<String> keys;

    Node(int val) {
        this.val = val;
        keys = new HashSet();
    }
}