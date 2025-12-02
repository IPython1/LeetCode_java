package twoPoint;

import java.util.Scanner;

public class acceptRainWater {
    public static int trap(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        //0 1 0 2 1 0 1 3 2 1 2 1
        //l                     r

        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (height[l] < height[r]) {
                ans += lMax - height[l];
                l++;
            } else {
                ans += rMax - height[r];
                r--;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(trap(nums));
    }

}
