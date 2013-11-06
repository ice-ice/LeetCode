public class Solution {
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        results.clear();
        calCombines(n, k, 1, new ArrayList<Integer>());
        return results;
    }
    
    public void calCombines(int n, int k, int c, ArrayList<Integer> list) {
        if (k > n - c + 1) return;
        if (k == n - c + 1) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.addAll(list);
            for (int i = k - 1; i >= 0; i--) {
                result.add(n - i);
            }
            results.add(result);
            return;
        }
        
        if (k == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.addAll(list);
            results.add(result);
            return;
        }
        
        list.add(c);
        calCombines(n, k - 1, c + 1, list);
        list.remove(list.size() - 1);
        calCombines(n, k, c + 1, list);
    }
}
