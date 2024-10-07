class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int row = 0; row < obstacleGrid.length; row++) {
            int[] nextRow = new int[n];
            for(int col = 0; col < n; col++) {

                nextRow[col] = obstacleGrid[row][col] != 1 ? dp[col] : 0;

                if(col > 0 && obstacleGrid[row][col] != 1  ) {
                    nextRow[col] += nextRow[col - 1];
                }
            }
            dp = nextRow;
        }

        return dp[n -1];
    }
}