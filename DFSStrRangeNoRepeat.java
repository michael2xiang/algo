import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 字符全排列，对结果去重复
 */
public class DFSStrRangeNoRepeat {
    public static void main(String[] args) {
        String s = "aba";
        DFSStrRangeNoRepeat obj = new DFSStrRangeNoRepeat();
        String[] res = obj.permutaion(s);
        for (int k = 0; k < res.length; k++) {
            System.out.println(res[k]);
        }
    }

    public String[] permutaion(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<String>();
        char[] arr = s.toCharArray();

        dfsHashSet(arr, 0, res, path);

        Arrays.sort(arr);
        boolean[] states = new boolean[s.length()];
        dfs(arr, 0, res, path, states);
        
        // list<string> to 数组
        return res.toArray(new String[res.size()]);

    }

    /**
     *  方法一，排序法 先对原数组排序，相关的数，会相邻，方便判重
     * @param arr
     * @param pos
     * @param res
     * @param path
     * @param states
     */
    public static void dfs(char[] arr, int pos, List<String> res, StringBuilder path, boolean[] states) {
        if (pos == arr.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (states[i] == false) {
                if (i > 0 && arr[i - 1] == arr[i] && states[i - 1] == false) {
                    continue;
                }
                states[i] = true;
                path.append(arr[i]);
                dfs(arr, pos + 1, res, path, states);
                states[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }

    }
    // 方法二：交换法，节省标记数组
    public static void dfsHashSet(char[] arr, int pos, List<String> res, StringBuilder path) {
        if (pos == arr.length) {
            res.add(path.toString());
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = pos; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            path.append(arr[i]);
            set.add(arr[i]);
            swap(arr, i, pos);
            dfsHashSet(arr, pos + 1, res, path);
            swap(arr, i, pos);
        }
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}