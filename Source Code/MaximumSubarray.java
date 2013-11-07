public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int sum = 0, max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum < 0) {
                max = sum > max ? sum : max;
                sum = 0;
            } else {
                max = sum > max ? sum : max;
            }
        }
        
        return max;
    }
}
