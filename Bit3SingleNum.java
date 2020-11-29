/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 示例 1：
 * 
 * 输入：nums = [3,4,3,3] 输出：4
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bit3SingleNum {
    public static void main(String[] args) {

    }

    /**
     * 统计所有数字的二进制中，每位1出现的次数，然后每位求3的余数，而是结果；
     * 
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        // 每位1出现的次数
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num = num >> 1;
            }
        }
        int res = 0, m = 3;
        // 二进制，还原数字
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

}
