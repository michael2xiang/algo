public class DP005 {
    /**
     * 对于一组不同重量，不同价格、不可分割的物品，我们需要选择一些装入背包， 在满足背包最大重量限制的前提下，背包中物品总价格的最大值是多少呢？
     * 
     * 动态规划 时间复杂度： m*n 空间复杂度： m
     * 
     * 如何减少空间复杂度？ 用一维数组，只保存添加背包的值
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = { 1, 3, 6, 2, 4, 5, 1 };
        int[] vals = { 4, 5, 1, 4, 7, 4, 9 };
        int w = 9;

        DP005 obj = new DP005();
        int maxValue = obj.dp(arrs, vals, w);
        System.out.println(maxValue);
    }

    public int dp(int[] arrs, int[] vals, int w) {
        int[] states = new int[w + 1];
        int len = arrs.length;
        for (int i = 0; i < w + 1; i++) {
            states[i] = -1;
        }

        states[0] = 0;
        if (arrs[0] <= w)
            states[arrs[0]] = vals[0];

        for (int row = 1; row < len; row++) {
            for (int col = w - arrs[row]; col > 0; col--) {
                if (states[col - 1] > 0) {
                    int val = states[col - 1] + vals[row];
                    if (val > states[col + arrs[row]]) {
                        states[col + arrs[row]] = val;
                    }
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int k = 0; k <=w; k++) {
            if (states[k] > 0) {
                maxValue = Math.max(maxValue, states[k]);
            }
        }
        return maxValue;
    }
}
