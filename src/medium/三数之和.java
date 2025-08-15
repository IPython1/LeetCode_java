package medium;

import java.util.*;
/**
 * @author dongyajie
 * @date 2025/8/14 11:32
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 答案中不可以包含重复的三元组
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;//先判断第一个位置不会出现重复的值
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum == 0) {//只需要先保证第一个数不遍历到相同的数字 后面两个数字如果满足sum==0再进行跳过
                    res.add(Arrays.asList(x, nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++) continue;//跳过第二个和第三个可能出现的重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--) continue;
                }
                if (sum > 0) {
                    k--;
                }
                if (sum < 0) {
                    j++;
                }
            }
        }
        return res;
    }
}
