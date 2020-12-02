import java.util.Deque;
import java.util.LinkedList;

/**
 * I. 滑动窗口的最大值 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 * 
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortMaxSlidingWindow {
    public static void main(String[] args) {
        // int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int[] nums = { 1, 3, -1, 5,5,5,5,5 };
        // int[] nums = { 1, 3, -1, 1,1,1,1,1 };
        int[] nums = { 3, 1, 2, -1, -1 };
        SortMaxSlidingWindow obj = new SortMaxSlidingWindow();
        int[] res = obj.maxSlidingWindow(nums, 3);
        for (int i : res) {
            System.out.print(i);
        }
    }

    /**
     * 总体单调递减的栈
     * 在向后移动滑动窗口时从[i,j] -> [i+1,j+1] 只需比较新加的j+1，删除=i，
     * 新加的j+1，如果放到合适递减位置，需从后->前，删除比它小，然后放入即可。
     * 删除，最大值=i
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        Deque deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) { // 总体单调递减的栈
            while (deque.isEmpty() == false && nums[i] > (int) deque.peekLast()) //从后->前，删除所有比新加入值小的
            {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        res[j++] = (int) deque.peekFirst();
        for (int i = k; i < nums.length; i++) { // 滑动
            if (deque.isEmpty() == false && (int) deque.peekFirst() == nums[i - k]) { // 删除=移除的值
                deque.pollFirst();
            }
            while (deque.isEmpty() == false && nums[i] > (int) deque.peekLast())//从后->前，删除所有比新加入值小的
            {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            res[j++] = (int) deque.peekFirst();
        }
        return res;
    }
}