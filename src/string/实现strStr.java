package string;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:05
 * @Description:
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标
 * （下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 **/
public class 实现strStr {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //
        System.out.println(strStr("hello","ll"));
    }

}
