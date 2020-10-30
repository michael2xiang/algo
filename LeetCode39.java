import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {

    /**
     * 深度优先搜索
     * 
     给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

        candidates 中的数字可以无限制重复被选取。

        说明：

        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。 
        示例 1：

        输入：candidates = [2,3,6,7], target = 7,
        所求解集为：
        [
        [7],
        [2,2,3]
        ]
        示例 2：

        输入：candidates = [2,3,5], target = 8,
        所求解集为：
        [
          [2,2,2,2],
          [2,3,3],
          [3,5]
        ]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
     
     */
    public static void main(final String[] args) {

    }
    public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
        final List<List<Integer>> ans = new ArrayList<List<Integer>>();
        final List<Integer> pathList = new ArrayList<Integer>();
        dfs(candidates, target, ans, pathList, 0);
        return ans;
    }
    
    public static List<List<Integer>> dfs(final int[] candidates, final int target, List<ArrarList<int>> ans ,List<int> pathList , int idx) {
        if(candidates.length == idx){
            return;
        }
        if(target==0){
            ans.add(new ArrarList<Integer>(pathList));
            return;
        }
        dfs(candidates,target,ans,pathList,idx+1);

        if(target- candidates[idx]>=0){
            pathList.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,pathList,idx);
            pathList.remove(pathList.size()-1);
        }
    }

}