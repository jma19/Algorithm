package google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by junm5 on 1/10/17.
 */
public class SlidingWindowMaximum {
    //dequeue double ended queue
    //store the index
    // put at the end

    /**
     * @param nums: input nums
     * @param k:    window size
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        //add to last
        Deque<Integer> deque = new LinkedList<Integer>();
        int n = nums.length, index = 0;
        int res[] = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //3 1 2

            while (!deque.isEmpty() && i - deque.peekFirst() == k){
                deque.poll();
            }
            //keep the head largest   4 2 5  3  7 9
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i] ) {
                deque.removeLast();
            }
            deque.offer(i);
            //0 1 2
            if(i >= k - 1){
                //
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
    public static void main(String [] args){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }
}