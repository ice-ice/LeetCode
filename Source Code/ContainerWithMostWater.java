public class Solution {
    public int maxArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int max = Integer.MIN_VALUE;
        
        int low = 0;
        int high = height.length - 1;
        
        while (low < high) {
            int local = (high - low) * Math.min(height[low], height[high]);
            
            if (local > max) {
                max = local;
            }
            
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return max;
    }
}
