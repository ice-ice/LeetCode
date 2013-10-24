public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (needle.length() > haystack.length()) {
            return null;
        }
        
        int l1 = haystack.length(), l2 = needle.length();
        
        for (int i = 0; i <= l1 - l2; i++) {
            if (isSame(haystack, i, needle, 0)) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
    
    boolean isSame(String s1, int l1, String s2, int l2) {
        while (l2 < s2.length()) {
            if (s1.charAt(l1++) != s2.charAt(l2++)) return false;
        }
        return true;
     }
}
