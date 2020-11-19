/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
*     root 
    小    大
 */
public class TreeLowestFather {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode maxNode = max(p, q);
        TreeNode minNode = min(p, q);
        while (root != null) {
            if (root.val > maxNode.val) {
                root = root.left;
            } else if (root.val < minNode.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    TreeNode max(TreeNode p, TreeNode q) {
        return p.val > q.val ? p : q;
    }

    TreeNode min(TreeNode p, TreeNode q) {
        return p.val > q.val ? q : p;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}