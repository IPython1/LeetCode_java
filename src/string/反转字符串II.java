package string;

import java.util.*;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:05
 * @Description:
 **/
public class 反转字符串II {
    public static void reverseString(char[] s) {
        //原地修改数组 使字符串完成反转  双指针
        for(int l=0,r=s.length-1;l<r;l++,r--){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
        }
    }
    //库函数的反转一般都是左闭右开规则
    public String reverseStr(String s, int k) {
        //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符
        //如果剩余字符少于 k 个，则将剩余字符全部反转
        //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
        char[] chars=s.toCharArray();

        return new String(chars);
    }
}
