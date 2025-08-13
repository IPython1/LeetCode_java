package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:31
 */
public class 买卖股票的最佳时机 {
    /*
        只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * 输入：prices = [7,6,4,3,1]
     * */
    public static int maxProfit(int[] prices) {
        //dp数组的定义
        //dp[i][0]:第i天持有股票的最大利润
        //dp[i][1]:第i天不持有股票的最大利润
        int len=prices.length;
        int[][] dp=new int[len][2];
        //初始化dp数组
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        //状态转移方程
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        //输出结果
        return dp[len-1][1];
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
