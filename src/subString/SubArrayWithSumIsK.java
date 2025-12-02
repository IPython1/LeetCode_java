package subString;
import java.util.*;
public class SubArrayWithSumIsK {
    public static int subarraySum(int[] nums, int k) {
        //给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
        //子数组是数组中元素的连续非空序列
        int count = 0;
        int[] sum = new int[nums.length]; // 前缀和数组
        Map<Integer, Integer> mp = new HashMap<>(); // 哈希表统计每个数字出现的次数

        // 求前缀和数组
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        // 添加前缀和为 0 的情况，这是为了处理以第一个元素开头的子数组
        mp.put(0, 1);
        // 遍历前缀和数组 「[j..i] 这个子数组和为 k 」这个条件我们可以转化为
        // pre[i]−pre[j−1]==k
        // 简单移项可得符合条件的下标 j 需要满足
        // pre[j−1]==pre[i]−k
        for (int i = 0; i < sum.length; i++) {
            // 检查是否存在 sum[i] - k
            if (mp.containsKey(sum[i] - k)) {
                count += mp.get(sum[i] - k);
            }
            mp.put(sum[i], mp.getOrDefault(sum[i], 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(subarraySum(nums,k));
    }
}
