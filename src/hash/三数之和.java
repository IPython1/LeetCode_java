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
        Arrays.sort(nums);//-4 -1 -1 0 1 2
        int len=nums.length;//6-2=4
        for(int i=0;i<len-2;i++){//固定一个位置的数
            int x=nums[i];//保证不重复的三元组 就是保证该位置不和遍历过的上一个位置重复
            if((i>0&&x==nums[i-1])||x>0){//比较下一个的话 可能会出现数组越界的问题 a去重
                continue;
            }
            int left=i+1;//其余两个位置用双指针确定
            int right=len-1;
            while(left<right){
                int sum=x+nums[left]+nums[right];//得到三个数的和
                if(sum==0){
                    res.add(Arrays.asList(x, nums[left], nums[right]));
                    //如果不跳过重复值，后续循环仍然s=0,会添加重复的三元组 并且会发生死循环 先收获结果再去重
                    for (left++; left < right && nums[left] == nums[left - 1]; left++); // 跳过重复数字
                    for (right--; right > left && nums[right] == nums[right + 1]; right--); // 跳过重复数字
                }else if(sum>0){//如果三个数的和大于0的话 right指针往左移动
                    right--;
                }else if(sum<0){//如果三个数的和小于0的话 left指针往右移动
                    left++;
                }
            }
        }
        return res;
    }
}
