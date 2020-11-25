import java.util.HashMap;
import java.util.Map;

public class StrLengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 输入: "pwwkew" 输出: 3 解释:
     * 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 
     * 动态规划 
     * dp[i] s[i]位置最长的不重复字符长度 
     * dp[i] = dp[i]+1 如没出现重复字符 
     * dp[i] = i - 上次出现重复字符的位置 如出现重复字符
     * 
     * 上次出现重复字符的位置 = max（上次出现重复字符的位置，s[i]上次出现的位置）
     * 
     * 空间优化，因为要最大值，不需dp[i]，在循环中每次保存最大值即可；
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        StrLengthOfLongestSubstring obj = new StrLengthOfLongestSubstring();
        String s = "abcabcbb";
        s = "bbbbb";
        s = "pwwkew";
        s = "au";
        s = "abba";
        s = "a";
        int res = obj.lengthOfLongestSubstring3(s);
        // int res = obj.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> dic = new HashMap<>();
        int val = 0, lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!dic.containsKey(s.charAt(i))) { // 不存在，则长度+1
                val = val + 1;
            } else { // 存在，长度=当前位置 - 上次重复位置 max（上次出现重复字符的位置，s[i]上次出现的位置）
                lastIndex = Math.max(lastIndex, dic.get(s.charAt(i)));
                val = i - lastIndex;
            }
            dic.put(s.charAt(i), i);
            res = Math.max(res, val);

        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> dic = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dic.put(s.charAt(0), 0);
        int tmp = 0;
        for (int i = 1; i < s.length(); i++) {
            if (!dic.containsKey(s.charAt(i))) {
                tmp = dp[i - 1] + 1;
            } else {
                int lastIndex = dic.get(s.charAt(i));
                tmp = i - lastIndex;
                dp[i] = tmp;
            }
            res = Math.max(res, tmp);
            dp[i] = tmp;
            dic.put(s.charAt(i), i);
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}