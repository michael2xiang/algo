import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPTriangleMinTotal {
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
     * 上一层结点下标 + 1 的两个结点。 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        DPTriangleMinTotal obj = new DPTriangleMinTotal();
        int res = obj.minimumTotal(triangle);
        System.out.println(res);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);

        int sum = 0;
        for (int j = 0; j < col; j++) {
            sum = sum + triangle.get(j).get(0);
            dp[j][0] = sum;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                int a = Integer.MAX_VALUE;
                if (dp[i - 1][j] > Integer.MIN_VALUE) {
                    a = dp[i - 1][j];
                }
                int b = Integer.MAX_VALUE;
                if (dp[i - 1][j - 1] > Integer.MIN_VALUE) {
                    b = dp[i - 1][j - 1];
                }
                dp[i][j] = triangle.get(i).get(j) + Math.min(a, b);
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (int k = 0; k < col; k++) {
            minVal = Math.min(minVal, dp[row - 1][k]);
        }

        //輸出選擇的路徑
        int k = 0;
        for (; k < col; k++) {
            if (dp[row - 1][k] == minVal) {
                break;
            }
        }

        System.out.println(triangle.get(row - 1).get(k));
        for (int r = row - 1; r > 0; r--) {
            for (int c = 0; c < col; c++) {
                if (dp[r][k] - triangle.get(r).get(k) == dp[r - 1][c]) {
                    System.out.println(triangle.get(r-1).get(c));
                    k = c;
                    break;
                }
            }
        }

        return minVal;
    }
}