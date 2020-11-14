import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelRead {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> lists = new ArrayList<Integer>();
        Queue queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            TreeNode tmp = (TreeNode) queue.poll();
            lists.add(tmp.val);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return lists.stream().mapToInt(k -> k).toArray();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}