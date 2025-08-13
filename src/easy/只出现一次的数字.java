package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:31
 */
public class 只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2,4};
        if (singleNumber(nums)==0) System.out.println("没有只出现一次的数字（但是也有可能这个数是0）");
        System.out.println(singleNumber(nums));
    }
}
