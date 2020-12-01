import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
/**
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


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
        List<List<Integer>> results = new ThreeSum().threeSum(nums);
        for (List<Integer> i : results) {
            for (Integer j : i) {
                System.out.print(j + " , ");
            }
            System.out.println();
        }
    }
}
