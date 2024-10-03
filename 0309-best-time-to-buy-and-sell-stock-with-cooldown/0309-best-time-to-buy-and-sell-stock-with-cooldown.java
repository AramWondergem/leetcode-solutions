class Solution {
    int[][] memo;
    int lastDay;
    int[] prices;
    
    public int maxProfit(int[] prices) {
        this.lastDay = prices.length;
        
        if(lastDay <= 1){
            return 0;
        }
        
        this.memo = new int[lastDay][2];
        this.prices = prices;
        
        for(int i = 0; i < lastDay; i++){
            Arrays.fill(memo[i], -1);
        }
        
        return dp(0,0);
        
    }
    
    private int dp(int day, int holding){
        if(day >= lastDay) {
            return 0;
        }
        
        if(memo[day][holding] != -1){
            return memo[day][holding];
        }
        
        int ans = dp(day + 1, holding); 
        
        if(holding == 1) {
            ans = Math.max(ans, this.prices[day] + dp(day + 2, holding - 1));
        } else {
            ans = Math.max(ans, -this.prices[day] + dp(day + 1, holding + 1));
        }
        
        this.memo[day][holding] = ans;
        
        return ans;   
    }
}