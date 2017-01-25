package LinkedIn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * using BFS to
 * Created by junm5 on 12/27/16.
 */
public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        StringBuffer stringBuffer = new StringBuffer();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                queue.offer(poll.left);
                queue.offer(poll.right);
                stringBuffer.append(poll.val + ",");
            } else {
                stringBuffer.append("#,");
            }
        }
        String res = stringBuffer.toString();
        return res.substring(0, res.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        String[] split = data.split("\\,");

        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = createNode(split[0]);
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = createNode(split[index]);
            if(left != null){
                queue.offer(left);
            }
            node.left = left;
            index++;
            TreeNode right = createNode(split[index]);
            node.right = right;
            if(right != null){
                queue.offer(right);
            }
            index++;
        }
        return root;
    }

    private TreeNode createNode(String str) {
        return str.equals("#") ? null :
                new TreeNode(Integer.valueOf(str));
    }

    public static void main(String[] args) {
        SerializeDeserializeTree serializeDeserializeTree = new SerializeDeserializeTree();
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        String serialize = serializeDeserializeTree.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = serializeDeserializeTree.deserialize(serialize);

        System.out.println(deserialize);

    }
}

