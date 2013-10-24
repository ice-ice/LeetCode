public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[][] table = new int[m + 2][n + 2];
        
        table[m + 1][n] = 1;
        
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                table[i][j] = table[i + 1][j] + table[i][j + 1];
            }
        }
        
        return table[1][1];
    }
}
