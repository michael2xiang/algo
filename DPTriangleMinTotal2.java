import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPTriangleMinTotal2 {
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
     * 上一层结点下标 + 1 的两个结点。 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * 状态转移方程：dp[j] = Min(dp[j],dp[j-1]) + triangle.get(i).get(j)
     * 从后往前填充，因为需上次的值，比较两次求最小值，从前往后填充，则开始就是覆盖上次的值，bug
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(n) n行中最大的元素个数
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        // triangle.add(Arrays.asList(-1));
        // triangle.add(Arrays.asList(-2, -3));

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        DPTriangleMinTotal2 obj = new DPTriangleMinTotal2();
        int res = obj.minimumTotal(triangle);
        System.out.println(res);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        int[] dp = new int[col];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int a = Integer.MAX_VALUE;
                if (dp[j] != Integer.MAX_VALUE) {
                    a = dp[j];
                }
                int b = Integer.MAX_VALUE;
                if (j - 1 >= 0 && dp[j - 1] != Integer.MAX_VALUE) {
                    b = dp[j - 1];
                }
                if (a != Integer.MAX_VALUE || b != Integer.MAX_VALUE) {
                    dp[j] = Math.min(a, b) + triangle.get(i).get(j);
                }
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (int k = 0; k < col; k++) {
            minVal = Math.min(minVal, dp[k]);
        }
        return minVal;
    }
}