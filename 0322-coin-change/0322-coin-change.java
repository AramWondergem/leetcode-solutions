class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0 ) {
            return 0;
        }

        int[] minCoinsPerStep = new int[amount + 1];

        for(int i = 1; i < minCoinsPerStep.length; i++) {
            int minCoinsPreviousStep = Integer.MAX_VALUE;
            for(int coin: coins) {
                if(i - coin >= 0){
                    minCoinsPreviousStep = Math.min(minCoinsPreviousStep,minCoinsPerStep[i - coin]);     
                }
            }
            minCoinsPerStep[i] = minCoinsPreviousStep <= amount ? minCoinsPreviousStep + 1: minCoinsPreviousStep;
        }

        return minCoinsPerStep[amount] <= amount ? minCoinsPerStep[amount] : -1;  
    }
}