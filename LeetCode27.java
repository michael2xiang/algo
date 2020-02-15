public class LeetCode27 {

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
