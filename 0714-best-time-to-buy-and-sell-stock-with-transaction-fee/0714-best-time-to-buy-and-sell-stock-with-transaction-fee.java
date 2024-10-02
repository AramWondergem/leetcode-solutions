class Solution {
    int[] prices;
    int fee;
    int numberOfDays;
    int[][] memo;
    
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        this.numberOfDays = prices.length;
        this.memo = new int[numberOfDays][2];
        
        for(int i = 0; i < numberOfDays; i++){
            Arrays.fill(memo[i], -1);
        }
        
        return dp(0, 0);
        
    }
    
    private int dp(int day, int holding) {
        if(day == numberOfDays){
            return 0;
        }
        
        if(memo[day][holding] != -1) {
            return memo[day][holding];
        }
        
        int ans = dp(day + 1, holding);
        
        if(holding == 1) {
            ans = Math.max(ans, this.prices[day] + dp(day + 1, holding - 1) - fee);
        } else {
            ans = Math.max(ans, -this.prices[day] + dp(day + 1, holding + 1));
        }
        
        this.memo[day][holding] = ans;
        
        return ans;
    }
}