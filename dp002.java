public class dp002{
    /**
     * 递归：从底向上，反过来推导，到第一个点|| 已经有结果，为递归结束条件
     * 状态定义： minDistBT(row,col) 到row行，col列的最短路径
     * 状态转移方程：minDistBT(row,col) = min(minDistBT(row-1,col),minDistBT(row,col-1)) + arr[row][col]
     * 达到当前点的最短路径 = 从上面||左边过来中最短路径  + 当前val;
     * 
     * 有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。
     * 棋子起始位置在左上角，终止位置在右下角。我们将棋子从左上角移动到右下角。
     * 每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。
     * 我们把每条路径经过的数字加起来看作路径的长度。
     * 那从左上角移动到右下角的最短路径长度是多少呢？
     */
    public static void main(String[] args) {
        int[][] array2 = { {1,2,3},{4,5,6},{7,8,9}};
        int row = arrs.length;
        int col = arrs[0].length;
        int[][] states = new int[row][col];

        minDistBT(array2,states,row-1,col-1);
    }
    public static int minDistBT(int[][] arrs,int[][] states,int row,int col){

        if(row==0 && col==0){
            return arrs[0][0];
        }
        if(states[row][col]>0){
            return states[row][col];
        }
        int upMin= Integer.MaxValue;
        if(row-1>0){
            upMin = minDistBT(arrs,states,row-1,col);
        }
        int leftMin = Integer.MinValue;
        if(col-1>0){
            leftMin = minDistBT(arrs,states,row,col-1);
        }
        int curDist = arrs[row][col]+ Math.min(leftMin,upMin);
        states[row][col]=curDist;
        return curDist; 
    }
}