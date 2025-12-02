package subString;

import java.util.*;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k +1];

        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i=k; i<nums.length; i++){
            if(deque.peekFirst() == nums[i-k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
