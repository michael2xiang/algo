public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmpHead = new ListNode(0); // 虚拟头节点
        ListNode p = tmpHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next =l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
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
        ListNode tmpNode = new LeetCode21().mergeTwoLists(d, g);
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " -> ");
            tmpNode = tmpNode.next;
        }
    }
}
