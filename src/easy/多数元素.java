package easy;

import java.util.*;

/**
 * @author dongyajie
 * @date 2025/8/7 10:31
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class 多数元素 {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    public int majorityElement2(int[] nums) {
        //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
        int len=nums.length;
        int ci=len/2;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<len;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            if(entry.getValue()>ci){
                return entry.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
