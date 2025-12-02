package twoPoint;

import java.util.*;
public class maxWaterContainer {
    public static int maxArea(int[] height) {
        int len = height.length;
        if (len == 0 || len == 1) return 0; // 如果数组为空或只有一个元素，则没有储水量
        int maxArea = 0;
        int left = 0, right = len - 1;//定义左右指针
        // 双指针法
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            // 移动指向较短高度的指针  这样移动的话才能保证最大 如果移动高度较高指针的话 面积会更小
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        // 返回容器的最大储水量
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] height=new int[n];
        for(int i=0;i<n;i++){
            height[i]=sc.nextInt();
        }
        System.out.println(maxArea(height));
    }
}
