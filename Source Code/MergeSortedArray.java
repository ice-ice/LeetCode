public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (n == 0) return;
        
        int lastA = m - 1, lastB = n - 1, i;
        int lastMerged = m + n - 1;
        
        i = lastMerged;
        
        while (i >= 0 && lastA >= 0 && lastB >= 0) {
            if (A[lastA] > B[lastB]) {
                A[i] = A[lastA];
                lastA--;
            } else {
                A[i] = B[lastB];
                lastB--;
            }
            i--;
        }
        
        while (lastB >= 0) {
            A[i--] = B[lastB--];
        }
    }
}
