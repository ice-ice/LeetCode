public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[] count = new int[3];
        
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }
        
        int index = 0;
        
        for (int i = 0; i < 3; i++) {
            while (count[i] > 0) {
                A[index++] = i;
                count[i]--;
            }
        }
    }
}
