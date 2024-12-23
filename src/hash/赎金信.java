package hash;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:04
 * @Description:
 * 给你两个字符串：ransomNote 和 magazine
 * 判断 ransomNote 能不能由 magazine 里面的字符构成
 * 如果可以，返回 true  否则返回 false
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 **/
public class 赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //判断 ransomNote 能不能由 magazine 里面的字符构成。
        //need[] 和 supply[]
        int[] need=new int[26];
        int[] supply=new int[26];
        for(int i=0;i<ransomNote.length();i++){
            need[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            supply[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(need[i]>supply[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //
        System.out.println(canConstruct("aa","aab"));
    }
}
