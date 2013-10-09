public class Solution {
    public int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int count = 0;
        
        for (int i = 0; i <= A.length - 2;) {
            int max = Integer.MIN_VALUE, index = 0;
            for (int j = A[i]; j >= 1; --j) {
                if (i + j >= A.length - 1) return count + 1;
                for (int k = A[i + j]; k>= 1; --k) {
                    if (max < i + j + k) {
                        max = i + j + k;
                        index = j;
                    }
                }
            }
            i += index;
            count++;
        }
        
        return count;
    }
}
