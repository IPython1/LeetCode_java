package subString;

import java.util.Scanner;

public class MinCoverSubString {
    public static String minWindow(String s, String t) {
        if(s == null || t == null){
            return s;
        }

        if(s.equals(t)){
            return s;
        }

        int[] cntS = new int[128];
        int[] cntT = new int[128];
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int left = 0;

        for(char c : t_array){
            cntT[c]++;
        }
        int ansLeft = -1;
        int ansRight = s.length();
        for(int right = 0; right < s.length(); right++){
            cntS[s_array[right]]++;
            while(iscovered(cntS, cntT)){
                if(right - left < ansRight - ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }

                cntS[s_array[left]]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    public static boolean iscovered(int[] cntS, int[] cntT){
        for(int i = 'a'; i <= 'z'; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }

        }

        for(int i = 'A'; i <= 'Z'; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        /** 同一行同时输入两个字符串
         *  String[] input = sc.nextLine().split("\\s+");
         *     String s = input[0];
         *     String t = input[1];
         */
        System.out.println(minWindow(s, t));
        sc.close();
    }
}
