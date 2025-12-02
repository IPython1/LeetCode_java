package twoPoint;

import java.util.*;

/**
 * 移动零
 */
public class changeZero {

    public static void moveZeroes(int[] nums) {
        //请注意 ，必须在不复制数组的情况下原地对数组进行操作
        int len=nums.length;
        // 0 1 0 3 12
        int j=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(int i=j;i<len;i++){
            nums[i]=0;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        moveZeroes(nums);
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
