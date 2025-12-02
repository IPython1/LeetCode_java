package hash;

import java.util.*;
public class MaxSequence {
    public static int longestConsecutive(int[] nums) {
        int res = 0; // 记录最长连续序列的长度
        Set<Integer> numSet = new HashSet<>(); // 记录nums中的所有数值

        // 将数组元素添加到HashSet中
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            // 如果当前的数是一个连续序列的起点，统计这个连续序列的长度
            if (!numSet.contains(num - 1)) {
                int seqLen = 1; // 连续序列的长度，初始为1
                int currentNum = num;
                // 不断查找连续序列，直到currentNum的下一个数不存在于数组中
                while (numSet.contains(++currentNum)) {
                    seqLen++;
                }
                // 更新最长连续序列长度
                res = Math.max(res, seqLen);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(longestConsecutive(nums));
    }
}
