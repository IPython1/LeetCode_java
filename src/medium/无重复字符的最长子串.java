package medium;

import java.util.Arrays;

/**
 * @author dongyajie
 * @date 2025/8/14 11:31
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 滑动窗口解题法：每次移动begin指针到重复字符的下一个位置 然后计算长度 求max
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
         char[] charS=s.toCharArray();
         int[] hash = new int[128];//题目标注了只存在字母
         int res=0;
         Arrays.fill(hash,-1);
         for (int begin = 0,i=0; i < charS.length; i++){
             begin=Math.max(begin,hash[charS[i]]+1);
             res=Math.max(res,i-begin+1);
             hash[charS[i]]=i;//保存每一个字符位置作为值
         }
        return res;
    }

}
