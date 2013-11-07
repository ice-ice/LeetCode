public class Solution {
    public int[] searchRange(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        return find(A, target, 0, A.length - 1);
    }
    
    public int[] find(int[] A, int target, int l, int r) {
        if (l > r) {
            int[] result = new int[2];
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        int mid = (l + r) / 2;
        if (A[mid] == target) {
            return range(A, target, mid);
        } else if (A[mid] < target) {
            return find(A, target, mid + 1, r);
        } else {
            return find(A, target, l, mid - 1);
        }
    }
    
    public int[] range(int A[], int target, int c) {
        int i = c, j = c;
        
        while (i >= 0 && A[i] == target) {
            i--;
        }
        
        while (j <= A.length - 1 && A[j] == target) {
            j++;
        }
        
        int[] result = new int[2];
        result[0] = i + 1;
        result[1] = j - 1;
        
        return result;
    }
}
