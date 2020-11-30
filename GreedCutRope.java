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
        int res = obj.cuttingRope(5);
        System.out.println(res);
    }

    // 动态规划法
    /**
     * 从最后一步，推导出动态规划方程： f(i) = f(i-最后一段)* 最后一段; 求最后一段，应该为多少，才能乘积最大？ 枚举全部情况，最大值就是结果
     * 
     * 从第一步开始应用公式，多推导几步，总结规律，是代码的逻辑实现过程
     * f(1) = 1 
     * f(2) = f(1)* 1 = 1 
     * f(3) = max(f(2) *1, f(1)*2) = 2 
     * f(4) = max(f(3)*1, f(2)*2, f(1)*3) = 4 
     * f(5) = max(f(4)*1,f(3)*2,f(2)*3,f(1)*4) = 4
     * 
     * 
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        // 绳子>4时，2,3 不需要剪
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) { // 因为对称所以只需要计算一半就好
                dp[i] = Math.max(dp[i], dp[i - j] * j);

            }
        }
        return dp[n];
    }

    // 数学法
    /**
     * 小于4的， n-1，剪1
     * 
     * 尽可能剪为 3 的 m 段
     * 最后一段有几种情况
     * 0： 3的m次方
     * 1:  3的m-1次方*4  最后一个不剪，留4为 2+2： 4 = 2+2(乘积4) > 1+3 (乘积3)
     * 2：3的m次方 * 2
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0)
            return (int) Math.pow(3, a);
        if (b == 1)
            return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

}