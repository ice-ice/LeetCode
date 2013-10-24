public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[][] matrix = new int[n][n];
        
        int i = 0, j = 0, direction = 0;
        
        int right = n - 1, left = 0, top = 1, bottom = n - 1, count = 1;
        
        while (count <= n * n && i >= 0 && i < n && j >= 0 && j < n) {
            switch (direction) {
                case 0:
                    if (j == right) {
                        matrix[i++][j] = count;
                        right--;
                        direction = 1;
                    } else {
                        matrix[i][j++] = count;
                    }
                    break;
                case 1:
                    if (i == bottom) {
                        matrix[i][j--] = count;
                        bottom--;
                        direction = 2;
                    } else {
                        matrix[i++][j] = count;
                    }
                    break;
                case 2:
                    if (j == left) {
                        matrix[i--][j] = count;
                        left++;
                        direction = 3;
                    } else {
                        matrix[i][j--] = count;
                    }
                    break;
                case 3:
                    if (i == top) {
                        matrix[i][j++] = count;
                        top++;
                        direction = 0;
                    } else {
                        matrix[i--][j] = count;
                    }
                    break;
            }
            count++;
        }
        
        return matrix;
    }
}
