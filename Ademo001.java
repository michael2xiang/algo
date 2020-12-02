import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Ademo001 {
    public static void main(final String[] args) {

        int[] array1 = { 1, 2, 3, 4 };
        // Arrays.sort(array1, (o1, o2) -> o1 > o2 ? -1 : 1);


        int[][] array2 = { {1,2,3},{4,5,6},{7,8,9}};

        // 优先级队列，默认是大顶推
        Queue<Integer> q = new PriorityQueue<>();
        q.add(3);// 添加元素，没空间抛异常
        q.remove();// 弹出元素，为空抛异常
        q.peek();// 查看队首元素，不出列
        q.offer(4);// 添加元素，不抛异常
        q.poll();// 弹出元素，不抛异常

        q.size();// 返回队列元素个数
        q.isEmpty();// 判断队列是否为空

        // 栈
        Stack<Integer> st = new Stack<Integer>();
        st.push(1); // 入栈
        st.push(2); // 入栈
        int i = st.size();
        StringBuilder sb = new StringBuilder();
        for (; i > 0; i--) {
            sb.append(st.pop());
        }
        String tmp = sb.toString();

        // Integer a = st.pop(); // 出
        // Integer b = st.pop(); // 出

        // 队列
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");// 添加头部元素
        queue.poll(); // 尾部返回第一个元素，并在队列中删除

        //双向队列
        Deque<String> dequeue = new LinkedList<>();
        //头add
        dequeue.offerFirst("b");
        //尾add
        dequeue.offerLast("a");
        //弹出
        dequeue.pollFirst();
        dequeue.pollLast();
        

        HashMap<String, String> map = new HashMap();
        map.put("a", "b");// 设置K键的值为V，存在k则覆盖
        map.putIfAbsent("a", "c"); // 不存在则insert，存在跳过
        map.get("a");// 获取K键的值
        map.remove("a");
        map.containsKey("a");// 判断是否有K键的值
        for (String key : map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
        }

        System.out.println("Hello World!");
    }
}
