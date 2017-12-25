public class StockWithFee{
    public int maxProfit(int[] prices, int fee){
        if(prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int[][] dp = new int[n][n];
        for(int i = 1; i < dp.length; i ++){
            for(int j = 1; j < prices.length; j++){
                dp[i][j] = dp[i][j - 1];
                for(int x = j - 1; x >= 0; x--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[j] - prices[x] - fee);
                }
            }
        }
        return dp[n-1][n - 1];
    }
}
