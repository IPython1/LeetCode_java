package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:04
 * @Description:
 **/
public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (mp.containsKey(target - nums[i])) {
                return new int[]{mp.get(target - nums[i]), i};
            }
            mp.put(nums[i],i);//key存储遍历的数 value存储数的下标
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=twoSum(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}
