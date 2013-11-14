public class Solution {
    public int search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        return find(A, 0, A.length - 1, target);
    }
    
    public int find(int[] A, int l, int r, int target) {
        if (l > r || l < 0 || r > A.length - 1) return -1;
        
        int mid = (l + r) / 2;
        
        if (target == A[mid]) return mid;
        
        if (A[l] <= A[mid]) {
            if (A[l] <= target && target < A[mid]) return find(A, l, mid - 1, target);
            else return find(A, mid + 1, r, target);
        } else {
            if (A[mid] < target && target <= A[r]) return find(A, mid + 1, r, target);
            else return find(A, l, mid - 1, target);
        }
    }
}
