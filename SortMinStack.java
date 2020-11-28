import java.util.Stack;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortMinStack {
    Stack<Integer> A, B;
    int min = Integer.MAX_VALUE;

    public SortMinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    // B为辅助栈，维护A最小值组成的，递减元素；即新入元素 > 现有的最小值，则入栈，并更新最小值
    public void push(int x) {
        A.push(x);

        if (x <= min) {
            B.push(x);
            min = x;
        }
        //效果一样，不用维护min，从B中拿 peek()取栈顶元素，不出栈；
        //问题，B.peek() 是Integer类型，比较引用地址，-128至127是被java缓存，所以比较值
        // if (B.isEmpty() || x <= B.peek()) {
        //     B.push(x);
        // }
    }

    public void pop() {
        Integer val = A.pop();
        if (B.peek().equals(val)) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();

    }
}
