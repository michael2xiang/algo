/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class TreeIsPostorder {
    public static void main(String[] args) {

    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 1) {
            return true;
        }
        return recur(postorder, 0, postorder.length - 1);
    }
   // 二叉搜索树，左结点都小于根结点，右节点都大于根结点
    public boolean recur(int[] postorder, int start, int end) {
        if (start <= end) {
            return true;
        }
        //后序，最后一个数为根结点
        int root = postorder[end];
        //从头遍历，第一个大于根结点的index，可以分为左、右子树
        int mid = 0;
        for (int i = 0; i < end - 1; i++) {
            if (postorder[i] > root) {
                mid = i;
                break;
            }
        }
     
        //右子树，是否都大于根结点，不符合则false
        int idx = mid;
        for (; idx < end; idx++) {
            if (postorder[idx] < root) {
                return false;
            }
        }
        //右子树，都大于根结点，就是 idx遍历到最后了 = end
        return idx == end && recur(postorder, start, mid - 1) && recur(postorder, mid, end - 1);

    }

}