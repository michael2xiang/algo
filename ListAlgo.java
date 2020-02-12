public class ListAlgo {

    // 链表反转，循环原地
    public static Node reverseList(Node list) {
        Node cur = list;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 求中间节点，快指针每次走两步，慢指针每次走一步，快比慢，以快一倍的速度走完时，慢指针就是中间节点
    public static Node getMiddleNode(Node list) {
        Node slow = list;
        Node fast = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static void printAll(Node list) {
        if (list == null)
            return;
        Node p = list;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
            if (p != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node five = new Node(5);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);
        System.out.println("原来列表：");
        printAll(one);
        Node after = reverseList(one);
        System.out.println("反转后列表：");
        printAll(after);

        Node middle = getMiddleNode(after);
        System.out.println("反转后的中间节点：" + middle.val);

    }

}
