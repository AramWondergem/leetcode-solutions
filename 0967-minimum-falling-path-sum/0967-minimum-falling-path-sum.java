class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = matrix[0];
        int[] directions = new int[]{-1,0,1};

        for(int row = 1; row < n; row++) {
            int[] nextRow = new int[n];

            for(int col = 0; col < n; col++) {
                int ans = Integer.MAX_VALUE;
                
                for(int dir: directions){
                    if(valid(col + dir, n)){
                    ans = Math.min(ans, dp[col + dir]);
                    }
                }

                nextRow[col] = ans + matrix[row][col];
            }

            dp = nextRow;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i : dp ) {
            ans = Math.min(ans, i);
        }
        
        return ans;
    }
    
    private boolean valid(int col, int n){
        return 0 <= col && col < n;
    }
}