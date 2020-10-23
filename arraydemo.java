// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// public class arraydemo{
//     public static void main(String[] args) {
    

//         给定1个二维字符数组m和单词1个w，搜索w是否在m中。搜索的定义是从m的任意位置开始，可以上下左右移动，依次和w每个字符匹配，如果w能匹配完，则存在，否则不存在。
//             - 例子："zoo"，"zoro"，"xtifx"都能够搜索成功，但"oto"搜索不成功。
//             a c d z
//             x t r o
//             f i o o

//             00:53 -》01:10

//             方法
//             https://www.cnblogs.com/xiaolovewei/p/8228100.html

//         int[] array2 = {1,2,3,4};
//         //Arrays.sort(array2, (o1, o2) -> o1 > o2?-1:1);

//         Queue<Integer> q = new PriorityQueue<>();

//         peek()//返回队首元素
//         poll()//返回队首元素，队首元素出队列
//         add()//添加元素
//         size()//返回队列元素个数
//         isEmpty()//判断队列是否为空，为空返回true,不空返回false


//         Stack<Integer> st = new Stack<Integer>();
//         st.push(new Integer(a)); //入栈
//         Integer a = (Integer) st.pop(); //出


//         Queue<String> queue = new LinkedList<String>();
        
//         queue.offer("a");//添加元素
//         queue.poll()); //返回第一个元素，并在队列中删除


//         HashMap<K, V> map=new HashMap<K, V>();
//         put(K,V);//设置K键的值为V
//         V get(K);//获取K键的值
//         boolean containsKey(K);//判断是否有K键的值

//         System.out.println("Hello World!");
//     }
// }
