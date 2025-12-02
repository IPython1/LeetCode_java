package slidingWindow;

import java.util.Scanner;

public class withoutRepeatedCharLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        //定义一个数组存储每个字符 上次 出现的位置(相当于哈希表)A 64+26=90 a 97+25=122 总共是有128个字符 所以设置字符长度大小为128
        int[] temp=new int[128];
        for(int i=0;i<temp.length;i++){
            temp[i]=-1;//因为每个字符第一次出现的话 跟0比较 所以预处理为-1
        }
        int ans=0;//定义一个结果变量
        //遍历整个字符串 begin初始索引 i向后遍历的索引 下面的方法可以遍历到所有不含有重复字符的子串
        for(int i=0,begin=0;i<s.length();i++){
            //遍历的同时 维护窗口的左右边界
            begin=Math.max(begin,temp[s.charAt(i)]+1);//如果当前字符重复的话  直接将begin指向之前重复字符的下一个位置 然后后边重新更新重复字符的位置
            ans=Math.max(ans,i-begin+1);
            temp[s.charAt(i)]=i;//存储当前字符的位置

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));

    }
}
