class Solution {
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int minCostClimbingStairs(int[] cost) {
        
        return dp(cost.length, cost);  
    }
    
    private int dp(int i, int[] cost){
        if(i <= 1) {
            return cost[i];
        }
        
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        
        int c = 0;
        
        if(cost.length != i){ 
            c = cost[i]; 
        }
        
        memo.put(i, Math.min(dp(i-1, cost), dp(i-2, cost)) + c);
  
        return memo.get(i);  
    }
}