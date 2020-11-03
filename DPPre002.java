public class DPPre002 {
    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包， 在满足背包最大重量限制的前提下 ，背包中物品总重量的最大值是多少呢？
     * 【回溯】穷举 
     * 优化点：
     * 使用二维数组，缓存已穷举过的状态，检查出已计算出，不用重复计算
     * 
     * 时间复杂度： m*n 到  2的n次方之间，接近 m*n，接近动态规划的时间复杂度
     * 空间复杂度： m*n
     * 
     * @param args
     */
    private int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arrs = { 1, 3, 6, 2, 4, 5, 1 };
        int w = 9;
        boolean[][] states = new boolean[arrs.length][w + 1];
        
        DPPre002 obj = new DPPre002();
        obj.func(arrs, 0, 0, w, states);
        System.out.println(obj.maxValue);
    }

    public void func(int[] arrs, int i, int cw, int w, boolean[][] states) {
        if (cw == w || i == arrs.length) {
            this.maxValue = Math.max(this.maxValue, cw);
            return;
        }

        if (states[i][cw])
            return;
        states[i][cw] = true;
        func(arrs, i + 1, cw, w, states);
        if (cw + arrs[i] <= w) {
            func(arrs, i + 1, cw + arrs[i], w, states);
        }

    }
}