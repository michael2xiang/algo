public class DFSFriendCircles {
    /**
     * 题目描述
        给定一个二维的 0-1 矩阵，如果第 (i, j) 位置是 1，则表示第 i 个人和第 j 个人是朋友。已知
        朋友关系是可以传递的，即如果 a 是 b 的朋友，b 是 c 的朋友，那么 a 和 c 也是朋友，换言之这
        三个人处于同一个朋友圈之内。求一共有多少个朋友圈。
        输入输出样例
        输入是一个二维数组，输出是一个整数，表示朋友圈数量。因为朋友关系具有对称性，该二
        维数组为对称矩阵。同时，因为自己是自己的朋友，对角线上的值全部为 1。
        Input:
        [[1,1,0],
        [1,1,0],
        [0,0,1]]
        Output: 2

     */
    public static void main(String[] args) {
       int[][] matric = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
       DFSFriendCircles obj = new DFSFriendCircles();
       int count = obj.findCircleNum(matric);
       System.out.println(count);
    }
    
    private int findCircleNum(int[][] matric) {
       int count = 0;
       boolean[] used = new boolean[matric.length];
       for (int i = 0; i < matric.length; i++) {
          if (used[i] == false) {
             dfs(matric, used, i);
             count++;
          }
       }
       return count;
    }

    private void dfs(int[][] matric, boolean[] used, int i) {
       used[i] = true;
       for (int j = 0; j < matric.length; j++) {
          if (matric[i][j] == 1 && used[i] == false) {
             dfs(matric, used, i);
          }
       }
    }
}
