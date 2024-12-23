package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:04
 * @Description:
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 *      0 <= i, j, k, l < n
 *      nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 **/
public class 四数相加 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        // 计算 nums1 和 nums2 中所有元素对的和，并存储在哈希表中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        // 计算 nums3 和 nums4 中所有元素对的和，并查找哈希表中是否存在相反数
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum = nums3[k] + nums4[l];
                count += sumMap.getOrDefault(-sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
