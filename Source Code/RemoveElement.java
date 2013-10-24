public class Solution {
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int last = A.length - 1;
        int len = A.length, i = 0;
        
        while (i <= last) {
            if (A[i] == elem) {
                len--;
                A[i] = A[last];
                A[last] = elem;
                last--;
            } else {
                i++;
            }
        }
        
        return len;
    }
}
