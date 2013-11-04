public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (x < 0) return false;
        
        int y = 0, m = x;
        
        while (m != 0) {
            int r = m % 10;
            y = y * 10 + r;
            m /= 10;
        }
        
        return x == y;
    }
}
