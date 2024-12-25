package string;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:05
 * @Description:
 **/
public class 反转字符串 {
    public static void reverseString(char[] s) {
        //原地修改数组 使字符串完成反转  双指针
        for(int l=0,r=s.length-1;l<r;l++,r--){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
        }
    }
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
}
