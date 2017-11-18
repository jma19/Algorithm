package Tree;

/**
 * Created by junm5 on 6/19/17.
 */
public class ReversePairs {
    private Node root = null;

    public long search(Node root, long val) {
        if (root == null) {
            return 0;
        } else if (val == root.val) {
            return root.cnt;
        } else if (val < root.val) {
            return root.cnt + search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        } else if (val == root.val) {
            root.cnt++;
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.cnt++;
            root.right = insert(root.right, val);
        }
        return root;
    }

    public int reversePairs(int[] nums) {
        int res = 0;
        Node root = null;

        for (int ele : nums) {
            res += search(root, 2L * ele + 1);
            root = insert(root, ele);
        }
        return res;
    }

    private int partion(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (nums[j] < pivot) {
                i++;
                exch(nums, i, j);
            }
        }
        exch(nums, low, i);
        return i;
    }

    private void exch(int[] nums, int low, int i) {
        int temp = nums[low];
        nums[low] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {6, 5, 4, 3, 2, 1};
        int i = reversePairs.reversePairs(nums);
        System.out.println(i);
    }
}

class Node {
    long val, cnt;
    Node left, right;

    public Node(int val) {
        this.val = val;
        this.cnt = 1;
    }
}