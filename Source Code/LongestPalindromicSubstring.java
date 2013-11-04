public class Solution {
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String tryStr = expandFromCenter(s, i, i);
            if (tryStr.length() > longest.length()) {
                longest = tryStr;
            }
            if (i + 1 < s.length()) {
                tryStr = expandFromCenter(s, i, i + 1);
                if (tryStr.length() > longest.length()) {
                    longest = tryStr;
                }
            }
        }
        
        return longest;
    }
    
    public String expandFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        
        return s.substring(l + 1, r);
    }
}
