/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
 */
public class BitSingleNum {
    public static void main(String[] args) {

    }

    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int i : nums) {
            tmp = (tmp ^ i);
        }
        // 最右边是1的位置
        // int mid = tmp & (tmp - 1);
        int mid = 1;
        while ((mid & tmp) == 0) {
            mid = mid << 1;
        }

        int a = 0, b = 0;
        for (int i : nums) {
            if ((i & mid) == 0) {
                a = i;
            } else {
                b = i;
            }
        }
        return new int[] { a, b };
    }

}