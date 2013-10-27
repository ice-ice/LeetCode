public class Solution {
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        results.clear();
        
        calPermute(num, 0, new ArrayList<Integer>());
        
        return results;
    }
    
    public void calPermute(int[] num, int current, ArrayList<Integer> result) {
        if (current == num.length) {
            results.add(result);
            return;
        }
        
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> new_result = new ArrayList<Integer>();
            
            for (int k : result) {
                new_result.add(k);
            }
            
            new_result.add(i, num[current]);
            
            calPermute(num, current + 1, new_result);
        }
        
        result.add(num[current]);
        
        calPermute(num, current + 1, result);
    }
}
