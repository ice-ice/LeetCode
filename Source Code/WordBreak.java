public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int len = s.length();
        
        if (len == 0) return true;
        
        boolean[] dp = new boolean[len + 1];

        dp[len] = true;
        
        int i = len - 1;
        while (i >= 0) {
            String cur = "";
            for (int j = i; j < len; j++) {
                cur += s.charAt(j);
                if (dict.contains(cur) && dp[j + 1] == true) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
            i--;
        }
        
        return dp[0];
    }
}
