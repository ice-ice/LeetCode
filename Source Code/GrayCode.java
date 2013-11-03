public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        
        for (int i = 0; i < n; i++) {
            for (int k = list.size() - 1; k >= 0; k--) {
                int current = list.get(k);
                current |= (1 << i);
                list.add(current);
            }
        }
        
        return list;
    }
}
