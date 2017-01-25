package Applovin;

/**
 * Created by junm5 on 1/16/17.
 */
public class LinkedList {
    private Node head;
    private Node last;
    private int size;

    public void addToTail(int data) {
        Node node = new Node(data);
        if (last == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            node.pre = last;
            last = node;
        }
        size++;
    }

    public void addToHead(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;

    }

    public boolean delete(int data) {
        Node current = head;
        Node pre = null;
        while (current != null) {
            if (current.data == data) {
                if (pre == null) {//detele head
                    head = head.next;
                    head.pre = null;
                }
                pre.next = current.next;
                if (current.next != null) {
                    current.next.pre = pre;
                }
                size--;
                return true;
            }
            pre = current;
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node temp = head;
        head = last;
        last = temp;
    }

}

class Node {
    int data;
    Node next;
    Node pre;

    public Node(int data) {
        this.data = data;
    }
}
