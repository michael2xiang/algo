public class LeetCode27 {

    /**
     * 
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int q = 0; q < nums.length; q++) {
            if (nums[q] != val) {
                nums[p] = nums[q];
                ++p;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        // int nums[] = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int nums[] = { 3, 2, 2, 3 };
        int val = 2;
        int length = new LeetCode27().removeElement(nums, val);
        System.out.println("length=" + length);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i] + " - ");
        }
    }
}
