/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。

 示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class BitSingleNum {
    public static void main(String[] args) {

    }

    /**
     * 一个数字出现一次，其他数字出现两次，依次异或即可（相同的会消除）
     * 两个数字，对数组分为两组，分别异或，即可得到这两个数
     * 如何分组？对数组整体异或后，为1的位代表这两个数，该位不同，例如，最右位
     * @param nums
     * @return
     */
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
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[] { a, b };
    }

}