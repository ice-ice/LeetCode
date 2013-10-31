public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        HashMap<Character, Boolean> maps = new HashMap<Character, Boolean>();
        int left = 0, right = 0, max = 0, current = 0;
        int len = s.length();
        
        while (right < len) {
            if (!maps.containsKey(s.charAt(right)) || maps.get(s.charAt(right)) == false) {
                maps.put(s.charAt(right), true);
                right++;
                current++;
            } else {
                while (left < right) {
                    maps.put(s.charAt(left), false);
                    current--;
                    left++;
                    if (s.charAt(left - 1) == s.charAt(right)) {
                        break;
                    }
                }
                maps.put(s.charAt(right), true);
                right++;
                current++;
            }
            max = current > max ? current : max;
        }
        
        return max;
    }
}
