class Solution {
    int[] memo;

    public int tribonacci(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        if(n >= 0 ){
            memo[0] = 0;
        }

        if( n >= 1) {
            memo[1] = 1;
        }
       
        if( n >= 2){
            memo[2] = 1; 
        }
        

        return dp(n);
    }

    private int dp(int n) {
        if(memo[n] != -1) {
            return memo[n];
        }

        this.memo[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);

        return this.memo[n];
    }
}