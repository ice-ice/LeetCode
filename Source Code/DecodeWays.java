public class Solution {
    public int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int len = s.length();
        if (len == 0) return 0;
        
        int[] dp = new int[len + 1];
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        } else {
            /*if (len != 1 && (s.charAt(len - 2) == '1' || s.charAt(len - 2) == '2')) {
                dp[len - 1] = 1;
            }*/
        }
        dp[len] = 1;
        
        for (int i = len - 2; i >= 0; i--) {
            int current = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            
            if (next == 0) {
                if (current == 1 || current == 2) {
                    dp[i] = dp[i + 2];
                } else {
                    return 0;
                }
            } else if (current == 1 || (current == 2 && next <= 6)) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (current == 0) {
                if (i == 0 || (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')) return 0;
                dp[i] = dp[i + 1];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        return dp[0];
    }
}
