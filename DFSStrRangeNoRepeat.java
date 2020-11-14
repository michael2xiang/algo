import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符全排列，对结果去重复
 */
public class DFSStrRangeNoRepeat {
    public static void main(String[] args) {
        String s = "aba";
        DFSStrRangeNoRepeat obj = new DFSStrRangeNoRepeat();
        String[] res = obj.permutaion(s);
        for(int k=0;k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    public String[] permutaion(String s){
        if(s==null ||s.length() ==0){
            return new String[0];
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<String>();
        boolean[] states = new boolean[s.length()];
        dfs(arr, 0, res, path, states);
        //list<string> to 数组
        return res.toArray(new String[0]);

    } 

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
}