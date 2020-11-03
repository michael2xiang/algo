public class DP003 {
    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包， 在满足背包最大重量限制的前提下 ，背包中物品总重量的最大值是多少呢？ 
     * 动态规划，填状态表法，行：总物品个数 = n，  列：背包的容量+1 = m，超过的忽略，加上合并重复值，将时间复杂度从指数级降为 m*n
     * 时间复杂度：m*n 
     * 空间复杂度： m*n
     * 
     * 如何减少空间复杂度？
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = { 1, 3, 6, 2, 4, 5, 1 };
        int w = 9;

        DP003 obj = new DP003();
        int maxValue = obj.dp(arrs, w);
        System.out.println(maxValue);
    }

    public int dp(int[] arrs, int w) {
        boolean[][] states = new boolean[arrs.length][w + 1];
        // 第一行特殊处理
        states[0][0] = true;
        if (arrs[0] <= w) {
            states[0][arrs[0]] = true;
        }

        // 动态规划开始，第二行从第一行推导出
        for (int row = 1; row < arrs.length; row++) {
            // 不添加到背包
            for (int col = 0; col < w; col++) {
                if (states[row - 1][col])
                    states[row][col] = states[row - 1][col];
            }
            // 添加到背包
            for (int col = 0; col <= w - arrs[row]; col++) {
                if (states[row - 1][col])
                    states[row][col + arrs[row]] = states[row - 1][col];
            }
        }

        int maxValue = Integer.MIN_VALUE;
        //从最后一行，后往前找，因为把所有物品都推导完，结果会在最后一行，而且最优的在后面，第一个符合的就是结果
        for (int k = w; k > 0; k--) {
            if (states[arrs.length - 1][k]) {
                maxValue = k;
                return maxValue;
            }
        }
        return maxValue;
    }
}
