public class Solution {
    public boolean exist(char[][] board, String word) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int m = board.length, n = board[0].length;
        
        int[][] used = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, word, i, j, used)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean check(char[][] board, String remains, int x, int y, int[][] used) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        
        if (used[x][y] == 1) return false;
        
        if (board[x][y] != remains.charAt(0)) {
            return false;
        } else {
            used[x][y] = 1;
            String remain = remains.substring(1);
            if (remain.length() == 0) return true;
            
            if (check(board, remain, x - 1, y, used)) return true;
            else if (check(board, remain, x + 1, y, used)) return true;
            else if (check(board, remain, x, y - 1, used)) return true;
            else if (check(board, remain, x, y + 1, used)) return true;
            
            used[x][y] = 0;
        }
        
        return false;
    }
}
