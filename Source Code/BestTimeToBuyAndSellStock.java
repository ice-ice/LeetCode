public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, profit = Integer.MIN_VALUE;
        int[] mins = new int[prices.length];
        
        if (prices.length <= 1) return 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            mins[i] = min;
        }
        
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            if ((max - mins[i]) > profit) {
                profit = max - mins[i];
            }
        }
        
        return profit;
    }
}
