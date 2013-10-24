public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if (strs.length == 0) return "";
        
        boolean flag = true;
        
        String prefix = "", previous = "";
        for (int i = 1; i < strs[0].length() + 1; i++) {
            previous = prefix;
            prefix = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    i = strs[0].length() + 1;
                    flag = false;
                    break;
                }
            }
        }
        
        return flag == true ? prefix : previous;
    }
}
