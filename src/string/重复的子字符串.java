package string;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:06
 * @Description:
 **/
public class 重复的子字符串 {
    public static boolean repeatedSubstringPattern(String s) {
        //给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
        //找到这个字符串的所有子串 然后依次比较看是否可以有子串多次构成
        //子串默认是从最开头开始的
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String substring = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j < s.length(); j += i) {
                    if (!substring.equals(s.substring(j, j + i))) {
                        flag = false;
                        break;
                    }
                }
               if (flag) {
                   return true;
               }
            }
        }

    }
    public static void main(String[] args) {

    }
}
