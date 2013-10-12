public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[] count = new int[32];
        for (int i = 0; i < A.length; i++) {
            int k = 0, current = A[i];
            while (k < 32) {
                if ((current & (1 << k)) != 0) {
                    count[k]++;
                }
                k++;
            }
        }
        
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                ret |= (1 << i);
            }
        }
        
        return ret;
    }
}
