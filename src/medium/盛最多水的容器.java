package medium;

/**
 * @author dongyajie
 * @date 2025/8/14 11:32
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 双指针解题
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int res=0;
        while(l<r){
            res=Math.max(res,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]) l++;
            else r--;

        }
        return res;

    }
}
