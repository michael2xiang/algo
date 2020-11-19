import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}