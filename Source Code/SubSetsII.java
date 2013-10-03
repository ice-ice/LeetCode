public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        
        getSubSets(num, 0, list, results);
        
        return results;
    }
    
    public void getSubSets(int[] num, int x, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> results) {
        if (x >= num.length) {
            ArrayList<Integer> _list = new ArrayList<Integer>();
            for (int d : list) {
                _list.add(d);
            }
            results.add(_list);
            return;
        }
        
        int current = num[x], count = 0;
        
        while (x < num.length && num[x] == current) {
            count++;
            x++;
        }
        
        for (int i = 0; i <= count; i++) {
            if (i != 0) {
                list.add(current);
            }
            getSubSets(num, x, list, results);
        }
        
        list.subList(list.size() - count, list.size()).clear();
    }
}
