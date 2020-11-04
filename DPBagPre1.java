public class DPBagPre1 {
    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，
     * 【回溯】穷举 时间复杂度：2的n次方，指数级
     * 在满足背包最大重量限制的前提下 ，背包中物品总重量的最大值是多少呢？
     * 
     * @param args
     */
    private int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arrs = { 1, 3, 6, 2, 4, 5, 1 };
        int w = 9;
        DPBagPre1 obj = new DPBagPre1();
        obj.func(arrs, 0, 0, w);
        System.out.println(obj.maxValue);
    }

    public void func(int[] arrs, int i, int cw, int w) {
        if (cw == w || i == arrs.length) {
            this.maxValue = Math.max(this.maxValue, cw);
            return;
        }

        func(arrs, i + 1, cw, w);
        if (cw + arrs[i] <= w) {
            func(arrs, i + 1, cw + arrs[i], w);
        }

    }
}