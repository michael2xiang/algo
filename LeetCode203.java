public class LeetCode203 {
/**
 * 删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
    public ListNode removeElement(ListNode head, int val) {
        ListNode tmpHead = new ListNode(0); //虚拟头节点
        tmpHead.next = head;
        ListNode cur = tmpHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(5, a);
        ListNode c = new ListNode(4, b);
        ListNode d = new ListNode(3, c);
        ListNode e = new ListNode(6, d);
        ListNode f = new ListNode(2, e);
        ListNode g = new ListNode(1, f);
        int val = 6;
        ListNode tmpNode = new LeetCode203().removeElement(g, val);
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " -> ");
            tmpNode = tmpNode.next;
        }
    }
}
