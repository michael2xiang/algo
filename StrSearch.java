import javafx.scene.chart.Chart;

public class StrSearch {
    /**

     */
    public static void main(String[] args) {
        char[][] arr = new char[][] { { 'a', 'c', 'd', 'z' }, { 'x', 't', 'r', 'o' }, { 'f', 'i', 'o', 'o' } };
        boolean r = searchStr(arr, "ax3");
        System.out.println(r);
    }

    public static boolean searchStr(char[][] arr, String word) {
        int row = arr.length;
        int col = arr[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(help(arr, word, i, j, 0, flag)) return true;
            }
        }
        return false;
    }

    public static boolean help(char[][] arr, String word, int row, int col, int index, boolean[][] flag) {
        boolean result = false;
        if (word.length()-1 == index)
            return true;
            // 
        if (row < 0 || row > word.length() || col < 0 || col > word.length() || arr[row][col] != word.charAt(index)
        || flag[row][col] )
        {
            return false;
        }
        flag[row][col] = true;
        index++;
        if (help(arr, word, row + 1, col, index, flag) || help(arr, word, row - 1, col, index, flag)
                || help(arr, word, row, col - 1, index, flag) || help(arr, word, row, col + 1, index, flag)) {
            return true;
        }
        flag[row][col] = false;
        return result;
    }

}