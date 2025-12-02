package twoPoint;

import java.util.*;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        //给你一个整数数组 nums
        //判断是否存在三元组 [ nums[i], nums[j], nums[k] ] 满足 i != j、i != k 且 j != k
        //同时还满足 nums[i] + nums[j] + nums[k] == 0
        //请你返回所有和为 0 且不重复的三元组 当前枚举的数和上一个数相同的话 跳过这个数
        List<List<Integer>> res = new ArrayList<>();

        // 使数组有序 然后用双指针 -4 -1 -1 0 1 2
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-2;i++){
            int x=nums[i];
            if(i>0&&x==nums[i-1]){//i>0 nums[i-1]就不会有数组越界的问题；比较下一个(nums[i-1])的话 可能会出现数组越界的问题；且保证不会出现重复的三元组
                continue;
            }
            int j=i+1;
            int k=len-1;
            while(j<k){
                int sum=x+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(x, nums[j], nums[k]));
                    //如果不跳过重复值，后续循环仍然s=0,会添加重复的三元组
                    for (j++; j < k && nums[j] == nums[j - 1]; j++); // 跳过重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--); // 跳过重复数字
                }else if(sum>0){//两数之和II相同的思路
                    k--;
                }else if(sum<0){
                    j++;
                }
            }

        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(threeSum(nums));
    }
}
