/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 
 *  
 * 
 * 示例:
 * 
 * 输入: a = 1, b = 1 输出: 2
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BitPlus {
    public static void main(String[] args) {

    }

    /**
     * 进位，两位都是1，即 a&b ，因进位，需左移一位
     * 本位，1,1=0 ； 1，0 or 0,1 =1; 0，0=0，异或运算
     * 进位 + 本位 直到进位为0
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1; // c = 进位
            a ^= b; // a = 本位
            b = c; // b = 进位
        }
        return a;
    }

}
