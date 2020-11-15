/**
 * 统计一个数字在排序数组中出现的次数。 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: 2 示例 2:
 */

public class Search1 {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        Search1 obj = new Search1();
        int res = obj.search(nums, target);
        System.out.println(res);
    }

    public int searchLeftRight(int[] nums, int target) {
        int left =0;
        int right = nums.length;
        

        
        return res;
    }
    


    // 递归法
    int res = 0;
    public int search(int[] nums, int target) {
        getCount(nums, target, 0, nums.length - 1);
        return res;
    }

    public int getCount(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = ((end - start) / 2) + start;
            if (nums[mid] == target) {
                res++;
                getCount(nums, target, start, mid - 1);
                getCount(nums, target, mid + 1, end);

            } else if (nums[mid] > target) {
                getCount(nums, target, start, mid - 1);
            } else {
                getCount(nums, target, mid + 1, end);
            }
        }
        return res;

    }

}