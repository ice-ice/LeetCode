public class Solution {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int len = A.length;
        if (len <= 1) return 0;
        
        int[] leftHighest = new int[len];
        int[] rightHighest = new int[len];
        
        int max = -1;
        for (int i = 1; i < len; i++) {
            if (A[i - 1] > max) {
                max = A[i - 1];
            }
            leftHighest[i] = max;
        }
        
        max = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i + 1] > max) {
                max = A[i + 1];
            }
            rightHighest[i] = max;
        }
        
        int water = 0;
        for (int i = 1; i < len - 1; i++) {
            int cur = Math.min(leftHighest[i], rightHighest[i]) - A[i];
            if (cur > 0) water += cur;
        }
        
        return water;
    }
}
