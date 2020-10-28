public class LeedCode542{
/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。
示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1

广度优先搜索，用队列存每层需搜索的数据
 */

        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dist = new int[row][col];
            boolean[][] used =  new boolean[row][col];

            Queue<int[]> queue = new LinkedList<int[]>();

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j] == 0){
                        queue.offer(new int[]{i,j});
                        used[i][j] = true;
                    }
                }
            }
            int[] xTmp={-1,1,0,0};
            int[] yTmp={0,0,-1,1};
            while(!queue.isEmpty()){
                int[] node =  queue.poll();
                int oldRow = node[0];
                int oldCol = node[1];
                for(int d=0;d<4;d++){
                    int newRow = oldRow + xTmp[d];
                    int newCol = oldCol + yTmp[d];
                    if(newRow>=0 && newRow<row && newCol >=0 && newCol<col && !used[newRow][newCol])
                    {
                        dist[newRow][newCol] = dist[oldRow][oldCol]+1;
                        used[newRow][newCol]=true;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }
            }
            return dist;
        }
    
    
}