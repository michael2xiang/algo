public class DPBag2Arrs {
    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包， 在满足背包最大重量限制的前提下 ，背包中物品总重量的最大值是多少呢？
     * 动态规划，填状态表法，行：总物品个数 = n， 列：背包的容量+1 = m，超过的忽略，加上合并重复值，将时间复杂度从指数级降为 m*n
     * 时间复杂度：m*n 空间复杂度： m*n
     * 
     * 如何减少空间复杂度？
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = { 1, 3, 6, 2, 4, 5, 1 };
        int w = 9;

        DPBag2Arrs obj = new DPBag2Arrs();
        int maxValue = obj.dp(arrs, w);
        System.out.println("可装最大重量："+ maxValue);
    }

    public int dp(int[] arrs, int w) {
        int len = arrs.length;
        boolean[][] states = new boolean[len][w + 1];
        // 第一行特殊处理
        states[0][0] = true;
        if (arrs[0] <= w) {
            states[0][arrs[0]] = true;
        }

        // 动态规划开始，第二行从第一行推导出
        for (int row = 1; row < len; row++) {
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
        // 从最后一行，后往前找，因为把所有物品都推导完，结果会在最后一行，而且最优的在后面，第一个符合的就是结果
        int k;
        for (k = w; k > 0; k--) {
            if (states[arrs.length - 1][k]) {
                maxValue = k;
                break;
            }
        }
        if (k == 0) {
            return maxValue;
        }
        //输出选择装入背包的物品信息
        for (int i = len - 1; i > 0; i--) {
            if (k - arrs[i] >= 0 && states[i][k - arrs[i]]) {
                System.out.println(arrs[i]);
                k = k - arrs[i];
            }
        }
        if(k!=0) System.out.println(arrs[0]);
        return maxValue;
    }
}
