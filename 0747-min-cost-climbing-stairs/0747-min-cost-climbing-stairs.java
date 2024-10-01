class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int twoBack = cost[0];
        int oneBack = cost[1];

        for(int i = 2; i <= cost.length; i++){
            int temp = oneBack;
            int c = i == cost.length ? 0 : cost[i];
            oneBack = Math.min(twoBack,temp) + c;
            twoBack = temp;
        }
        
        return oneBack;  
    }
}