package DataStructure;

import java.util.Arrays;

/**
 * Created by junm5 on 2/7/17.
 */
public class HeapImpl {
    private int CAPACITY = 10;
    private int size = 0;
    private int[] data;

    public HeapImpl() {
        data = new int[CAPACITY];
    }

    //some helper methods
    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private void ensureCapacity() {
        if (size == CAPACITY) {
            data = Arrays.copyOf(data, CAPACITY * 2);
            CAPACITY = CAPACITY * 2;
        }
    }

    private void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = data[0];
        data[0] = data[size - 1];
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallest = getLeftChildIndex(index);
            if (hasRightChild(index) && data[getRightChildIndex(index)] < data[smallest]) {
                smallest = getRightChildIndex(index);
            }
            if (data[index] < data[smallest]) {
                break;
            } else {
                swap(smallest, index);
                index = smallest;
            }
        }
    }

    public void add(int item) {
        ensureCapacity();
        data[size++] = item;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && data[getParentIndex(index)] > data[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
//    public static void main(String [] args){
//        HeapImpl heap = new HeapImpl();
//        heap.add(2);
//        heap.add(4);
//        heap.add(5);
//        heap.add(0);
//        heap.add(9);
//        heap.add(100);
//        heap.add(15);
//        System.out.println(heap.poll());
//        System.out.println(heap.poll());
//        System.out.println(heap.poll());
//        System.out.println(heap.poll());
//
//    }
}

