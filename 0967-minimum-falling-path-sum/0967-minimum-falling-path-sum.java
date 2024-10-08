class Solution {
    int n;
    int[][] matrix;
    int[][] memo;
    int[] directions;
    
    public int minFallingPathSum(int[][] matrix) {
        this.n = matrix.length;
        this.matrix = matrix;
        this.memo = new int[n][n];
        this.directions = new int[]{-1,0,1};
        
        for(int[] array: this.memo){
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int col = 0; col < n; col++){
            ans = Math.min(ans, dp(n - 1, col));
        }
        
        return ans;
    }
    
    private int dp(int row, int col) {
        if(row == 0) {
            return this.matrix[row][col];
        }
        
        if(this.memo[row][col] != Integer.MAX_VALUE){
            return this.memo[row][col];
            
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int dir: this.directions){
            if(valid(col + dir)){
                ans = Math.min(ans, dp(row - 1, col + dir));
            }
        }
        
        this.memo[row][col] = ans + matrix[row][col];
        
        return this.memo[row][col];
    }
    
    private boolean valid(int col){
        return 0 <= col && col < this.n;
    }
}