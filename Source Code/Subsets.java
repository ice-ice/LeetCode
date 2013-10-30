public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(S);
        
        int len = S.length, base = 0x0;
        
        int num = (int)Math.pow(2, len);
        
        while (base < num) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            int current = base;
            
            for (int i = 0; i < len; i++) {
                if ((current & (1 << i)) != 0) {
                    list.add(S[i]);
                }
            }
            
            results.add(list);
            
            base++;
        }
        
        return results;
    }
}
