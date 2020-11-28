import java.util.Deque;
import java.util.LinkedList;

public class SortMaxQueue {
    public static void main(String[] args) {
        SortMaxQueue obj = new SortMaxQueue();
        obj.push_back(1);
        obj.push_back(7);
        int param_1 = obj.max_value();
        System.out.println(param_1);
        obj.pop_front();
        int param_2 = obj.max_value();
        System.out.println(param_2);
    }

    Deque deque;
    Deque tmpDeque;

    public SortMaxQueue() {
        deque = new LinkedList<Integer>();
        tmpDeque = new LinkedList<Integer>();
    }

    public int max_value() {
        return tmpDeque.isEmpty() ? -1 : (int) tmpDeque.peekFirst();
    }

    public void push_back(int value) {
        deque.offer(value);
        while (tmpDeque.isEmpty() == false && (int) tmpDeque.peekLast() < value) {
            tmpDeque.pollLast();
        }
        tmpDeque.offerLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        int val = (int) deque.poll();
        if (val == (int) tmpDeque.peekFirst()) {
            tmpDeque.pollFirst();
        }
        return val;

    }
}