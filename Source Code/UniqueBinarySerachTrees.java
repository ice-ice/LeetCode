public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - 1 - j];
            }
        }
        
        return count[n];
    }
}
