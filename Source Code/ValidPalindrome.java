public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int i = 0, j = s.length() - 1;
        
        s = s.toLowerCase();
        
        while (i < j) {
            if (s.charAt(i) < '0' || (s.charAt(i) > '9' && s.charAt(i) < 'a') || s.charAt(i) > 'z') {
                i++;
                continue;
            }
            
            if (s.charAt(j) < '0' || (s.charAt(j) > '9' && s.charAt(j) < 'a') || s.charAt(j) > 'z') {
                j--;
                continue;
            }
            
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        
        return i >= j ? true : false;
    }
}
