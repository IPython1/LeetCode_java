package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:05
 * @Description:
 **/
public class 四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
        //（若两个四元组元素一一对应，则认为两个四元组重复）
        List<List<Integer>> res = new ArrayList<>();
        int len=nums.length;
        Arrays.sort(nums);//-2 -1 0 0 1 2
        for(int i=0;i<len-3;i++){
            if(i>0&&nums[i]==nums[i-1]){//比较下一个的话 可能会出现数组越界的问题 a去重
                continue;
            }
            for(int j=i+1;j<len-2;j++){
                int x=nums[i]+nums[j];
                if((j>i+1&&nums[j]==nums[j-1])){//比较下一个的话 可能会出现数组越界的问题 b去重
                    continue;
                }
                int left=j+1;
                int right=len-1;
                while(left<right){
                    long sum=(long)x+nums[left]+nums[right];//得到四个数的和
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left], nums[right]));
                        //如果不跳过重复值，后续循环仍然s=0,会添加重复的三元组 并且会发生死循环 先收获结果再去重
                        for (left++; left < right && nums[left] == nums[left - 1]; left++); // 跳过重复数字
                        for (right--; right > left && nums[right] == nums[right + 1]; right--); // 跳过重复数字
                    }else if(sum>target){//如果四个数的和大于0的话 right指针往左移动
                        right--;
                    }else if(sum<target){//如果四个数的和小于0的话 left指针往右移动
                        left++;
                    }
                }


            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
