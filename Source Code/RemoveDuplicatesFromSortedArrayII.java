public class Solution {
    HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
    
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        maps.clear();
        
        int len = A.length, i = 0, last = A.length - 1;
        
        while (i < len) {
            if (!maps.containsKey(A[i])) {
                maps.put(A[i], 1);
            } else if (maps.get(A[i]) == 2) {
                int tmp = A[i];
                A[i] = A[last];
                A[last] = tmp;
                len--;
                last--;
                continue;
            } else {
                maps.put(A[i], 2);
            }
            i++;
        }
        
        if (len > 1) Arrays.sort(A, 0, len);
        
        return len;
    }
}
