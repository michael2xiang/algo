import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSIntRange {

    /**
     * 深度优先搜索
     * 
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。 示例: 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3],
     * [2,3,1], [3,1,2], [3,2,1] ]
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * 
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        boolean[] used = new boolean[arr.length];
        LinkedList<Integer> pathList = new LinkedList<Integer>();
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(arr, arr.length, used, pathList, res);
        System.out.println(res);

    }

    private static void dfs(int[] arr, int length, boolean[] used,  LinkedList<Integer> pathList,
            List<ArrayList<Integer>> res) {
        if (pathList.size() == length) {
            res.add(new ArrayList<Integer>(pathList));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i] == false) {
                used[i] = true;
                pathList.add(arr[i]);
                dfs(arr, length, used,  pathList, res);
                used[i] = false;
                pathList.removeLast();
            }
        }

    }

}