package hash;

import java.util.*;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:04
 * @Description:双指针法解题
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 **/
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums){
        //给你一个整数数组 nums
        //判断是否存在三元组 [ nums[i], nums[j], nums[k] ] 满足 i != j、i != k 且 j != k
        //同时还满足 nums[i] + nums[j] + nums[k] == 0
        //请你返回所有和为 0 且不重复的三元组 当前枚举的数和上一个数相同的话 跳过这个数
        List<List<Integer>> res = new ArrayList<>();

        // 使数组有序 然后用双指针
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-2;i++){
            int x=nums[i];
            if(i>0&&x==nums[i-1]){//比较下一个的话 可能会出现数组越界的问题
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
                }else if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }
            }

        }
        return res;
    }
}
