public class DPMinDist1 {
    /**
     * 动态转移表，从上到底，顺序推导； 操作二维数组：每轮，根据上次最优的结果，填写这轮的表； 注意点: 1.第一行，第一个列，先处理，之后根据这个向后推
     * 2.结果是：二维数组的最后一个元素，因为是根据每次的最优子结果推导出来的
     * 
     * 有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。 棋子起始位置在左上角，终止位置在右下角。我们将棋子从左上角移动到右下角。
     * 每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。 我们把每条路径经过的数字加起来看作路径的长度。
     * 那从左上角移动到右下角的最短路径长度是多少呢？
     * 
     * 状态转移方程：
     *  min_dist(i, j) = w[i][j] + min(min_dist(i, j-1), min_dist(i-1, j))
     *  i，j 为行，列，需两个for循环，依赖j-1,i-1，所以需提前处理第1行，第1列的数据；
     * 
     */
    public static void main(String[] args) {
        int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int min = minDistBT(array2);
        System.out.println(min);
    }

    public static int minDistBT(int[][] arrs) {
        int row = arrs.length;
        int col = arrs[0].length;
        int[][] states = new int[row][col];
        int sum = 0;
        // 第一行
        for (int i = 0; i < row; i++) {
            sum = sum + arrs[0][i];
            states[0][i] = sum;
        }

        sum = 0;
        // 第一列
        for (int j = 0; j < col; j++) {
            sum = sum + arrs[j][0];
            states[j][0] = sum;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int a = states[i - 1][j] + arrs[i][j];
                int b = states[i][j - 1] + arrs[i][j];
                states[i][j] = Math.min(a, b);
            }
        }
        return states[row - 1][col - 1];

    }

}
