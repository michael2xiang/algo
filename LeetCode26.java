public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if (nums[q] != nums[p]) 
            {
                ++p;
                nums[p] = nums[q];
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int length = new LeetCode26().removeDuplicates(nums);
        System.out.println("length=" + length);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i] + " - ");
        }
    }
}
