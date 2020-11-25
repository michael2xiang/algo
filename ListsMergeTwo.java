public class ListsMergeTwo {

    /**
     * 
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
     * 
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmpHead = new ListNode(0); // 虚拟头节点
        ListNode p = tmpHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next =l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
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

        ListNode e = new ListNode(10);
        ListNode f = new ListNode(11, e);
        ListNode g = new ListNode(12, f);
        ListNode tmpNode = new ListsMergeTwo().mergeTwoLists(d, g);
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " -> ");
            tmpNode = tmpNode.next;
        }
    }
}
