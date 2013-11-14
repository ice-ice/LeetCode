public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int len1 = s.length(), len2 = p.length();
        
        if (len2 == 0) return len1 == 0;
        else if (len1 == 0) return (len2 > 1 && p.charAt(1) == '*') ? isMatch(s, p.substring(2)) : false;
        
        char ss = s.charAt(0), pp = p.charAt(0);
        
        if (len2 > 1 && p.charAt(1) == '*') {
            if (pp == '.') return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            else if (ss == pp) return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            else return isMatch(s, p.substring(2));
        } else if (pp == '.') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (ss == pp) {
            return isMatch(s.substring(1), p.substring(1));
        }
        
        return false;
    }
}
