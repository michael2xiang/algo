public class LongestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
        示例 1：
        输入: "babad"
        输出: "bab"
        注意: "aba" 也是一个有效答案。
        示例 2：
        输入: "cbbd"
        输出: "bb"
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/longest-palindromic-substring
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindrome obj = new LongestPalindrome();
        String len = obj.longestPalindrome(s);
        System.out.println(len);
    }

    public String longestPalindrome(String s) {
        int allLen = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < allLen; i++) {
            int len1 = findFromCenter(s.toCharArray(), i, i, allLen);
            int len2 = findFromCenter(s.toCharArray(), i, i + 1, allLen);
            int maxLen = Math.max(len1, len2);
            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int findFromCenter(char[] s, int start, int end, int len) {
        while (start >= 0 && end < len && s[start] == s[end]) {
            --start;
            ++end;
        }
        return end - start - 1;

    }

}