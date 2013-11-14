public class Solution {
    public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int i = num.length - 2;
        
        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }
        
        if (i == -1) {
            Arrays.sort(num);
            return;
        }
        
        Arrays.sort(num, i + 1, num.length);
        
        for (int k = i + 1; k < num.length; k++) {
            if (num[k] > num[i]) {
                int tmp = num[k];
                num[k] = num[i];
                num[i] = tmp;
                return;
            }
        }
    }
}
