public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int len = A.length;
        if (len == 0 || len == 1) return len;
        
        int lastNum = A[0];
        int index = 1;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] == lastNum) {
                len--;
            } else {
                lastNum = A[i];
                A[index++] = A[i];
            }
        }
        
        return len;
    }
}
