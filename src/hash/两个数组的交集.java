package hash;

import java.util.*;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:04
 * @Description:
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 **/
public class 两个数组的交集 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        //请使用set对nums1和nums2中的数字进行去重
        Set<Integer> set1=new HashSet<Integer>();
        Set<Integer> set2=new HashSet<Integer>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        int n= Math.min(set1.size(), set2.size());
        int[] res=new int[n];
//        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
        //遍历Set1中所有元素
        int i=0;
        for(int num:set1){
            //判断set2中是否有相同的元素
            if(set2.contains(num)){
                res[i++]=num;
            }
        }
        return Arrays.copyOf(res, i); // 根据实际交集大小截取数组
}

    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
