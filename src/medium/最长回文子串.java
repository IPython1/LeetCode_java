package medium;

/**
 * @author dongyajie
 * @date 2025/8/14 11:31
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 返回这个字符串的最长子串。
 * 多维动态规划中的题目
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String t = "babad";
        System.out.println(longestPalindrome(t));
    }

    public static String longestPalindrome(String s) {
        int index = 0;
        int res = 1;

        for (int i = 0; i < s.length(); i++) {
            int len1 = get(s, i, i);    // 传递字符串参数
            int len2 = get(s, i, i + 1); // 传递字符串参数
            int len = Math.max(len1, len2);

            if (len > res) {
                res = len;
                index = i - (len - 1) / 2;
            }
        }
        return s.substring(index, index + res);
    }

    public static int get(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
