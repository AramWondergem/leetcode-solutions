// dp solution
        // parameters are the position in the grid
        // return the numbers of ways possible to get to that position
        // dp(row, col) = dp(row -1, col) + dp(row, col - 1) --> check for bounds
        // bases case: row and col == 1 (obstacle) return 0
        // row+ col = 0 --> return 1
        // memorization

class Solution {
    int m;
    int n; 
    int[][] grid;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.grid = obstacleGrid;
        this.memo = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return dp(m - 1, n - 1);
    }
    
    private int dp(int row, int col) {
        if(this.grid[row][col] == 1) {
            return 0;
        }
        
        if(row + col == 0){
            return 1;
        }
        
        if(this.memo[row][col] != -1){
            return this.memo[row][col];
        }
        
        int ans = 0;
        
        if(row > 0){
            ans += dp(row -1, col);
        }
        
        if(col > 0){
            ans += dp(row, col - 1);
        }
        
        this.memo[row][col] = ans;
        
        return ans;
    }
}