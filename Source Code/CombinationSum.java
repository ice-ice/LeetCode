public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        combineSum(candidates, 0, target, list, results);
        
        return results;
    }
    
    public void combineSum(int[] candidates, int x, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> results) {
        if (x >= candidates.length && target > 0) {
            return;
        }
        
        while (x < candidates.length && candidates[x] <= target) {
            if (candidates[x] < target) {
                list.add(candidates[x]);
                combineSum(candidates, x, target - candidates[x], list, results);
                list.subList(list.size() - 1, list.size()).clear();
            } else if (candidates[x] == target){
                ArrayList<Integer> _list = new ArrayList<Integer>();
                for (int d : list) {
                    _list.add(d);
                }
                _list.add(candidates[x]);
                results.add(_list);
                return;
            }
            x++;
        }
    }
}
