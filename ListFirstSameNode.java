/**
 * 两个链表的第一个公共节点
https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class ListFirstSameNode {
    

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 统计链表A和链表B的长度
        int lenA = length(headA), lenB = length(headB);

        // 如果节点长度不一样，节点多的先走，直到他们的长度一样为止
        while (lenA != lenB) {
            if (lenA > lenB) {
                // 如果链表A长，那么链表A先走
                headA = headA.next;
                lenA--;
            } else {
                // 如果链表B长，那么链表B先走
                headB = headB.next;
                lenB--;
            }
        }

        // 然后开始比较，如果他俩不相等就一直往下走
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        // 走到最后，最终会有两种可能，一种是headA为空，
        // 也就是说他们俩不相交。还有一种可能就是headA
        // 不为空，也就是说headA就是他们的交点
        return headA;
    }

    // 统计链表的长度
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}