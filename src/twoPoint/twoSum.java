package twoPoint;

import java.util.Scanner;

public class twoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        // Arrays.sort(numbers);
        while(l<r){
            int sum=numbers[l]+numbers[r];
            if(sum==target){
                return new int[]{l,r};
            }else if(sum>target){
                r--;
            }else if(sum<target){
                l++;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        int[] res=twoSum(nums, target);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }

}
