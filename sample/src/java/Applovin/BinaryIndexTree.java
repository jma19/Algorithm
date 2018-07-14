package Applovin;

/**
 * Created by junm5 on 7/3/18.
 */
public class BinaryIndexTree {
    private int[] nodes;
    private int size;

    public BinaryIndexTree(int size) {
        this.size = size + 1;
        this.nodes = new int[size + 1];
    }

    public void update(int index, int val) {
        index++;
        while (index < size) {
            this.nodes[index] += val;
            index += Integer.lowestOneBit(index);
        }
    }

    public int sum(int index) {
        ++index;
        int ans = 0;
        while (index > 0) {
            ans += nodes[index];
            index -= Integer.lowestOneBit(index);
        }
        return ans;
    }

    public int query(int i, int j) {
        return sum(j) - sum(i - 1);
    }

}
