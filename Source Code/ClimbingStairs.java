public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (n <= 2) return n;
        
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        
        int i = 2;
        while (i <= n) {
            steps[i] = steps[i - 1] + steps[i - 2];
            i++;
        }
        
        return steps[n];
    }
}
