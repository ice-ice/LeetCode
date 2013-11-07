public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        
        int[][] path = new int[m + 1][n + 1];
        path[m][n - 1] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) path[i][j] = 0;
                else path[i][j] = path[i + 1][j] + path[i][j + 1];
            }
        }
        
        return path[0][0];
    }
}
