class Solution {
    public int maxProfit(int[] prices) {
        int m = prices.length;

        if(m <= 1) {
            return 0;
        }

        int[][] dp = new int[m + 2][2];

        for(int day = m - 1; day >= 0; day--){
            for(int holding = 0; holding < 2; holding++){

                int ans = dp[day + 1][holding];

                if(holding == 1) {
                    ans = Math.max(ans, prices[day] + dp[day + 2][holding - 1]);
                } else {
                    ans = Math.max(ans, -prices[day] + dp[day + 1][holding + 1]);
                }

                 dp[day][holding] = ans;
            }
        }

        return dp[0][0];
    }
}