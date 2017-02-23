package amaon;

/**
 * Created by junm5 on 2/20/17.
 */

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}

public class RangeSumQuery {
    SegmentTreeNode root = null;


}
