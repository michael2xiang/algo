import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class TreeRebuild {
    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeRebuild obj = new TreeRebuild();
        TreeNode node = obj.buildTree(preorder, inorder);
        System.out.println(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return doAction(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
    }

    public TreeNode doAction(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inOrderMap) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return node;
        }
        int rootIndex = inOrderMap.get(preorder[preStart]);
        int leftNodeNum = rootIndex - inStart;
        int rightNum = inEnd - rootIndex;

        node.left = doAction(preorder, preStart + 1, preStart + leftNodeNum, inorder, inStart, rootIndex - 1,
                inOrderMap);
        node.right = doAction(preorder, preEnd - rightNum + 1, preEnd, inorder, rootIndex + 1, inEnd, inOrderMap);
        return node;

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