public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int lenA = A.length, lenB = B.length;
        
        int[] C = new int[lenA + lenB];
        
        int iA = 0, iB = 0, iC = 0;
        
        while (iA < lenA && iB < lenB) {
            if (A[iA] < B[iB]) {
                C[iC++] = A[iA++];
            } else {
                C[iC++] = B[iB++];
            }
        }
        
        while (iA < lenA) {
            C[iC++] = A[iA++];
        }
        
        while (iB < lenB) {
            C[iC++] = B[iB++];
        }
        
        int mid = (lenA + lenB) / 2;
        if ((lenA + lenB) % 2 == 0) return (double)(C[mid] + C[mid - 1]) / 2;
        else return C[mid];
    }
}
