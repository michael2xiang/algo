
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dj09d/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TreeToDoublyList {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null)
            return;
        dfs(cur.left);
        if (pre != null)
            pre.right = cur;
        else
            head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}