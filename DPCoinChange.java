import java.util.Arrays;

public class DPCoinChange {
    /**给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
        你可以认为每种硬币的数量是无限的。
        示例 1：
        输入：coins = [1, 2, 5], amount = 11
        输出：3 
        解释：11 = 5 + 5 + 1
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/coin-change
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
        
        最小硬币数 = 最后一个硬币面额的最小数+1
        f(0)=0
        f(1) = Min(f(1-1),f(1-2),f(1-5))+1 = 1 负数的跳过，保存结果下次用
        f(2) = Min(f(2-1),f(2-2),f(2-3))+1 = 1
        f(3) = Min(f(3-1),f(3-2),f(3-3))+1 = 1
        f(4) = Min(f(4-1),f(4-2),f(4-3))+1 = 2
        */
    public static void main(String[] args) {
        int[] arrs = { 1, 2, 5 };
        int amount = 11;
        // int[] arrs = { 2 };
        // int amount = 3;
        DPCoinChange obj = new DPCoinChange();
        int res = obj.coinChange(arrs, amount);
        System.out.println(res);

    }

    public int coinChange(int[] arrs, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j < arrs.length; j++) {
                if (i - arrs[j] >= 0) {
                    minCount = Math.min(minCount, dp[i - arrs[j]]);
                }
            }
            if (minCount != Integer.MAX_VALUE) {
                dp[i] = minCount + 1;
            }

        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}