package hash;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:04
 * @Description:
 **/
public class 快乐数 {
    public static int newNum(int n){
        int newN=0;
        while(n!=0){
            int k=n%10;//每次拿出最后一位数
            newN=newN+k*k;
            n=n/10;
        }
        return newN;
    }

    public static boolean isHappy(int n) {
        int count=0;
        /*「快乐数」 定义为：
        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false */
        while (true){
            if (n==1) break;
            n=newNum(n);
            count+=1;
            if (count>32) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        //请设计输入输出用例
        System.out.println(isHappy(19));
    }
}
