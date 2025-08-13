package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:30
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 根据时间复杂度反推解法 所以这里应该使用二分查找
 * 二分查找最关键的地方是要找到一个性质 能将区间进行二分
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int len=nums.length;
        int l=0,r=len-1;
        while(l<r){
            int mid=l+r>>1;
            if(nums[mid]>=target) r=mid;
            else l=mid+1;
        }
        if(target>nums[l]) return l+1;
        else return l;
    }
}
//这段代码在给定示例 nums = {1,3,5,6} 和 target = 2 时的执行流程。
//
//初始状态
//
//• nums = {1, 3, 5, 6}
//
//        • target = 2
//
//        • len = 4 (数组长度)
//
//        • l = 0 (左边界)
//
//        • r = 3 (右边界)
//
//第一次循环 (l=0, r=3)
//
//1. 计算中间索引 mid：
//        • mid = l + r >> 1 等价于 mid = (l + r) / 2，即 (0 + 3) / 2 = 1。
//
//        2. 比较 nums[mid] 和 target：
//        • nums[1] = 3，target = 2。
//
//        • 3 >= 2 为 true，所以更新右边界 r = mid = 1。
//
//        3. 更新后：
//        • l = 0, r = 1。
//
//第二次循环 (l=0, r=1)
//
//1. 计算中间索引 mid：
//        • mid = (0 + 1) / 2 = 0。
//
//        2. 比较 nums[mid] 和 target：
//        • nums[0] = 1，target = 2。
//
//        • 1 >= 2 为 false，所以更新左边界 l = mid + 1 = 1。
//
//        3. 更新后：
//        • l = 1, r = 1。
//
//循环结束
//
//此时 l == r，循环条件 l < r 不满足，循环终止。
//
//最终判断
//
//1. 比较 target 和 nums[l]：
//        • nums[1] = 3，target = 2。
//
//        • 2 > 3 为 false，所以返回 l = 1。
//
//结果
//
//函数返回 1，表示 target = 2 应该插入到索引 1 的位置（即在 1 和 3 之间）。
//
//验证
//
//插入 2 到索引 1 后，数组变为 {1, 2, 3, 5, 6}，确实是正确的有序插入位置。
//
//总结
//
//• 初始数组：[1, 3, 5, 6]，target = 2。
//
//        • 二分查找过程：
//
//        • mid=1，nums[1]=3 >= 2，r=1。
//
//        • mid=0，nums[0]=1 < 2，l=1。
//
//        • 最终 l=1，nums[1]=3 > 2 不成立，返回 l=1。
//
//        • 结果：1。
