public class ListReverse {
/**
 * 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
    //循环方式
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode tmpNode = null;
        ListNode cur = head;
        while (cur != null) {
            tmpNode = cur.next;
            cur.next = p;
            p = cur;
            cur = tmpNode;
        }
        return p;
    }

    ListNode p = null;
    ListNode tmpNode = null;

    //递归方式
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null) {
            return p;
        }
        tmpNode = head.next;
        head.next = p;
        p = head;
        head = tmpNode;
        return reverseListRecursion(head);
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
        // ListNode tmpNode = new LeetCode206().reverseList(g);
        ListNode tmpNode = new ListReverse().reverseListRecursion(g);
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " -> ");
            tmpNode = tmpNode.next;
        }
    }
}
