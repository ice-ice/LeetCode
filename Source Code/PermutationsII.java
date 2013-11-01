public class Solution {
    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        set.clear();
        results.clear();
        
        Arrays.sort(num);
        
        calSet(num, 0, new ArrayList<Integer>());
        
        return results;
    }
    
    public void calSet(int[] num, int i, ArrayList<Integer> list) {
        if (i == num.length) {
            if (!set.contains(list)) {
                set.add(list);
                results.add(list);
            }
            return;
        }
        for (int j = 0; j < list.size(); j++) {
            ArrayList<Integer> newlist = new ArrayList<Integer>();
            newlist.addAll(list);
            newlist.add(j, num[i]);
            calSet(num, i + 1, newlist);
        }
        list.add(num[i]);
        calSet(num, i + 1, list);
    }
}
