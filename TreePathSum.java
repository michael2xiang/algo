import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreePathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null)
            return res;
        get(root, sum, root.val, res, path);
        return res;
    }

    public void get(TreeNode node, int sum, int k, List<List<Integer>> res, LinkedList<Integer> path) {
        if (k == sum && node.left == null && node.right == null) {
            res.add(new ArrayList(path));
            return;
        }
        path.add(node.val);
        get(node.left, sum, k + node.left.val, res, path);
        get(node.right, sum, k + node.right.val, res, path);
        path.removeLast();
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