public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Arrays.sort(num);
        
        int min = Integer.MAX_VALUE, value = target;
        
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                int diff = num[left] + num[right] + num[i] - target;
                if (min > Math.abs(diff)) {
                    min = Math.abs(diff);
                    value = diff + target;
                }
                
                if (diff == 0) return target;
                else if (diff < 0) left++;
                else right--;
            }
        }
        
        return value;
    }
}
