/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]
 * 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * 示例 1：
 * 
 * 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 动态规划法
 */
public class GreedCutRope {
    public static void main(String[] args) {
        GreedCutRope obj = new GreedCutRope();
        int res = obj.cuttingRope(10);
        System.out.println(res);
    }

    //动态规划法
    public int cuttingRope(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);

            }
        }
        return dp[n];
    }
    //数学法

}