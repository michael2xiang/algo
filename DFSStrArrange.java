import java.util.ArrayList;
import java.util.List;

public class DFSStrArrange {
    /**
     * 字符全排列
     * @param args
     */
    public static void main(String[] args) {
        String s = "abc";
        boolean[] states = new boolean[s.length()];

        List<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
        List<Character> path = new ArrayList<Character>();
        dfs(s.toCharArray(), 0, states, res, path);
        System.out.print(res);
    }

    public static void dfs(char[] arrs, int idx, boolean[] states, List<ArrayList<Character>> res,
            List<Character> path) {
        if (path.size() == arrs.length) {
            res.add(new ArrayList<Character>(path));
            return;
        }

        for (int i = 0; i < arrs.length; i++) {
            if (states[i] == false) {
                states[i] = true;
                path.add(arrs[i]);
                dfs(arrs, idx + 1, states, res, path);
                states[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}