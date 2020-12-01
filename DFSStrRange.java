import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSStrRange {
    /**
     * 字符全排列
     * @param args
     */
    public static void main(String[] args) {
        String s = "aba";
        List<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
        LinkedList<Character> path = new LinkedList<Character>();
        boolean[] states = new boolean[s.length()];

        dfs(s.toCharArray(),  states, res, path);
        System.out.print(res);
    }

    public static void dfs(char[] arrs,boolean[] states, List<ArrayList<Character>> res,
    LinkedList<Character> path) {
        if (path.size() == arrs.length) {
            res.add(new ArrayList<Character>(path));
            return;
        }

        for (int i = 0; i < arrs.length; i++) {
            if (states[i] == false) {
                states[i] = true;
                path.add(arrs[i]);
                dfs(arrs,  states, res, path);
                states[i] = false;
                path.removeLast(); //队列 O(1)时间复杂度移除队尾元素
            }
        }
    }
}