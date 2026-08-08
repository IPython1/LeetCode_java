package qiuzhao_2027;

import java.util.*;

public class 线性dp_数字三角形 {

    /**
     * 数字三角形核心函数
     *
     * @param a 数字三角形，a[i][j] 表示第 i 层第 j 个数，编号从 1 开始
     * @param n 三角形层数
     * @return 最大路径和
     */
    public static int solve(int[][] a, int n) {

        // TODO: 在这里填写核心代码
        //dp数组初始化
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){//自底向上去找数
            dp[n][i]=a[n][i];
        }
        for (int i=n-1;i>=1;i--){
            for(int j=n-1;j>=1;j--){
                dp[i][j]=Math.max(dp[i+1][j]+a[i][j],dp[i+1][j+1]+a[i][j]);
            }
        }
        return dp[1][1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] a = new int[n + 1][n + 1];

        // 读入数字三角形
        for (int i = 1; i <= n; i++) {//n行m列
            for (int j = 1; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ans = solve(a, n);

        System.out.println(ans);
    }
}