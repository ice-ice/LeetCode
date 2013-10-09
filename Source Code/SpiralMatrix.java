public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (matrix.length == 0) return list;
        
        int m = matrix.length, n = matrix[0].length;
        
        int i = 0, j = 0, direction = 0;
        
        int right = n - 1, left = 0, top = 1, bottom = m - 1;
        
        while (list.size() < m * n && i >= 0 && i < m && j >= 0 && j < n) {
            switch (direction) {
                case 0:
                    if (j == right) {
                        list.add(matrix[i++][j]);
                        right--;
                        direction = 1;
                    } else {
                        list.add(matrix[i][j++]);
                    }
                    break;
                case 1:
                    if (i == bottom) {
                        list.add(matrix[i][j--]);
                        bottom--;
                        direction = 2;
                    } else {
                        list.add(matrix[i++][j]);
                    }
                    break;
                case 2:
                    if (j == left) {
                        list.add(matrix[i--][j]);
                        left++;
                        direction = 3;
                    } else {
                        list.add(matrix[i][j--]);
                    }
                    break;
                case 3:
                    if (i == top) {
                        list.add(matrix[i][j++]);
                        top++;
                        direction = 0;
                    } else {
                        list.add(matrix[i--][j]);
                    }
                    break;
            }
        }
        
        return list;
    }
}
