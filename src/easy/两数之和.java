package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:27
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 两数之和 {
    //使用hashmap解决
    private static Map<Integer, Integer> mp=new HashMap<>();
    public static int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(mp.containsKey(target-nums[i])){
                return new int[]{mp.get(target-nums[i]),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int[] res=twoSum(nums,9);
        System.out.println(res[0]+" "+res[1]);
    }
}
