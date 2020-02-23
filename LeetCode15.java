import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    //去重：包含外层循环，里面的双指针
    //边界条件，数值超index
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList();
        if (nums == null || len < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right && nums[i] <= 0) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left = left + 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right = right - 1;
                    }
                    right = right - 1;
                    left = left + 1;
                } else if (tmp > 0) {
                    right = right - 1;
                } else if (tmp < 0) {
                    left = left + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        // int nums[] = { 0, 0, 0, 0 };
        List<List<Integer>> results = new LeetCode15().threeSum(nums);
        for (List<Integer> i : results) {
            for (Integer j : i) {
                System.out.print(j + " , ");
            }
            System.out.println();
        }
    }
}
