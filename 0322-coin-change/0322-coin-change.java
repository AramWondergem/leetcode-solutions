class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    int[] coinsCol;
    int a;

    public int coinChange(int[] coins, int amount) {
        if(amount == 0 ) {
            return 0;
        }

        coinsCol = coins;
        a = amount;

        int minCoinsPreviousStep = Integer.MAX_VALUE;

        for(int coin: coinsCol) {
            minCoinsPreviousStep = Math.min(minCoinsPreviousStep,dp(amount - coin));     
        }
    
        return minCoinsPreviousStep <= a ? minCoinsPreviousStep + 1 : -1;  
    }

    private int dp(int i){
        if(i == 0) {
            return 0;
        }

        if(i < -1) {
            return Integer.MAX_VALUE;
        }

        if(memo.containsKey(i)) {
            return memo.get(i);
        }

        int minCoinsPreviousStep = Integer.MAX_VALUE;
        for(int coin: coinsCol) {
            minCoinsPreviousStep = Math.min(minCoinsPreviousStep, dp(i - coin));     
        }

        memo.put(i, minCoinsPreviousStep <= a ? minCoinsPreviousStep + 1: minCoinsPreviousStep);
        return memo.get(i); 
    }
}