import java.util.LinkedList;
import java.util.Queue;

public class LeedCode542 {
    /**
     * 
     * 广度优先搜索，用队列存每层需搜索的数据
     * 
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * 
     * 两个相邻元素间的距离为 1 。 示例 2: 输入:
     * 
     * 0 0 0 0 1 0 1 1 1 输出:
     * 
     * 0 0 0 0 1 0 1 2 1
     * 
     */

    public int[][] updateMatrix(final int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;
        final int[][] dist = new int[row][col];
        final boolean[][] used = new boolean[row][col];

        final Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    used[i][j] = true;
                }
            }
        }
        final int[] xTmp = { -1, 1, 0, 0 };
        final int[] yTmp = { 0, 0, -1, 1 };
        while (!queue.isEmpty()) {
            final int[] node = queue.poll();
            final int oldRow = node[0];
            final int oldCol = node[1];
            for (int d = 0; d < 4; d++) {
                final int newRow = oldRow + xTmp[d];
                final int newCol = oldCol + yTmp[d];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && !used[newRow][newCol]) {
                    dist[newRow][newCol] = dist[oldRow][oldCol] + 1;
                    used[newRow][newCol] = true;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }
        return dist;
    }

}