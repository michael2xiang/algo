import java.util.ArrayList;
import java.util.List;

public class DFSSumTarget {

    /**
     * 深度优先搜索
     * 
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * 
     * candidates 中的数字可以无限制重复被选取。
     * 
     * 说明：
     * 
     * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1：
     * 
     * 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ] 示例 2：
     * 
     * 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5]
     * ]
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     */
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum( int[] candidates,  int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
         List<Integer> pathList = new ArrayList<Integer>();
        dfs(candidates, target, ans, pathList, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> pathList, int idx) {
        if (candidates.length == idx) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(pathList));
            return;
        }
        //当前值不加进去，移动idx 
        dfs(candidates, target, ans, pathList, idx + 1);

        if (target - candidates[idx] >= 0) {
            pathList.add(candidates[idx]);
            //加上当前值
            dfs(candidates, target - candidates[idx], ans, pathList, idx);
            pathList.remove(pathList.size()-1);
        }
    }

}