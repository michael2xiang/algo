import java.util.LinkedList;
import java.util.Queue;
/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
作者：Krahets
链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59zt5i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class TreeMirror {
    public static void main(String[] args) {

    }

    public void treeMirror(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (queue.size() > 0) {
            TreeNode tmp = (TreeNode) queue.poll();
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            TreeNode swp = tmp.left;
            tmp.left = tmp.right;
            tmp.right = swp;
        }
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