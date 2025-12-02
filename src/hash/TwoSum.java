package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();//键存储数字 值存储下标
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                return new int[]{i,mp.get(target-nums[i])};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取数组长度
        int n = sc.nextInt();
        int[] nums = new int[n];

        // 读取数组元素
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 读取目标值
        int target = sc.nextInt();

        // 调用twoSum方法
        int[] result = twoSum(nums, target);

        // 输出结果
        System.out.println("["+result[0] + "," + result[1]+"]");
    }
}
