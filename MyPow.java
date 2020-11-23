/**
 * 数值的整数次方 实现函数double Power(double base, int
 * exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow obj = new MyPow();
        double res1 = obj.getPow(2, 9);
        double res2 = obj.getPowGood(2, 9);
        System.out.println(res1);
        System.out.println(res2);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            double tmp = getPow(x, -n);
            return 1 / tmp;
        } else {
            return getPow(x, n);
        }
    }

    // 循环，时间复杂度: O(n)
    public double getPow(double x, int n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    /**
     * 二分法，时间复杂度： O(log n)
     * 二进制位中位1的，才算入结果
     * eg: 3的9次方，因为 9 的二进制 1001 所以 = 3的4次 * 3的1次方
     * 如果 b%2=1 等价 b&1=1，则算入结果
     * b/2 等价 b>>1 左移一位，因为刚已判断过了，
     * @param x
     * @param n
     * @return
     */

    public double getPowGood(double x, int n) {
        int b = n;
        double res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * x;
            }
            b = b / 2;
            x = x * x;
        }
        return res;
    }

}
