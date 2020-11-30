public class DPBag1Arrs {
    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包， 在满足背包最大重量限制的前提下 ，背包中物品总重量的最大值是多少呢？ 、
     * 
     * 动态规划 
     * 
     * 时间复杂度： m*n 
     * 空间复杂度： m
     * 
     * 改用一维数组，只保存添加背包的值，减少空间复杂度
     * 
     * 前一个有装入，添加到背后的重量
     * dp[i] = dp[i+arr[i]] set true if dp[i-1] == true
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = { 1, 3, 6, 2, 4, 5, 1 };
        int w = 9;

        DPBag1Arrs obj = new DPBag1Arrs();
        int maxValue = obj.dp(arrs, w);
        System.out.println(maxValue);
    }

    public int dp(int[] arrs, int w) {
        boolean[] states = new boolean[w + 1];
        int len = arrs.length;
        states[0] = true;
        if (arrs[0] <= w)
            states[arrs[0]] = true;

        for (int row = 1; row < len; row++) {
            for (int col = w - arrs[row]; col > 0; col--) {
                if (states[col - 1])
                    states[col + arrs[row]] = states[col - 1];
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int k = w; k > 0; k--) {
            if (states[k]) {
                maxValue = Math.max(maxValue, k);
                return maxValue;
            }
        }
        return maxValue;
    }
}
