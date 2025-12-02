package slidingWindow;

import java.util.*;
public class allogeneicLettersWithString {

    public  static List<Integer> findAnagrams(String s, String p) {
        // 找到s中所有p的异位词的子串，返回这些子串的起始索引
        int slen = s.length();
        int plen = p.length();
        Map<Character, Integer> mp = new HashMap<>();
        List<Integer> res = new LinkedList<>(); // 存储索引结果
        int begin = 0;
        if(slen<plen) return res;
        // 将p中出现的字符个数统计出来
        for (char ch : p.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        // 遍历主串的过程中将mp哈希映射中的值进行减少，并判断值是否小于0
        // 如果小于0，证明当前字符不是p中有的字符，则将begin指针进行移动
        for (int i = 0; i < slen; i++) {
            char curChar = s.charAt(i);
            mp.put(curChar, mp.getOrDefault(curChar, 0) - 1);
            // 当前字符数量小于0，说明出现了多余的字符，调整窗口左边界
            while (mp.get(curChar) < 0) {
                mp.put(s.charAt(begin), mp.get(s.charAt(begin)) + 1);//恢复原先窗口的与p中相同字符数量 如果不恢复的话，滑动窗口左边界会一直右移
                begin++;
            }
            // 窗口大小等于模式串长度时记录开始位置
            if (i - begin + 1 == plen) {
                res.add(begin);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();//空格也能读取进去
        String p=sc.nextLine();
        System.out.println(findAnagrams(s,p));
    }
}
