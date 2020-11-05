
public class DPMinPathSum {
    /**
        给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        说明：每次只能向下或者向右移动一步。
        示例:
        输入:
        [
            [1,3,1],
            [1,5,1],
            [4,2,1]
        ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/minimum-path-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        DPMinPathSum obj = new DPMinPathSum();
        int res = obj.minPathSum(grid);
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        int sum = 0;
        for (int r = 0; r < row; r++) {
            sum += grid[r][0];
            dp[r][0] = sum;
        }
        sum = 0;
        for (int c = 0; c < col; c++) {
            sum += grid[0][c];
            dp[0][c] = sum;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

}