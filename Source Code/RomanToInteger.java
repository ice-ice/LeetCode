public class Solution {
    public int romanToInt(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        HashMap<String, Integer> maps = new HashMap<String, Integer>();
        
        for (int i = 0; i < symbols.length; i++) {
            maps.put(symbols[i], nums[i]);
        }
        
        int sum = 0, i = 0;
        String current = "";
        
        while (i < s.length()) {
            current = "" + s.charAt(i);
            if (i < s.length() - 1) {
                String tmp = current + s.charAt(i + 1);
                if (maps.containsKey(tmp)) {
                    sum += maps.get(tmp);
                    i += 2;
                    continue;
                }
            }
            sum += maps.get(current);
            i++;
        }
        
        return sum;
    }
}
