public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<Integer> mins = new ArrayList<Integer>();
        
        for (int i = 0; i < triangle.size(); i++) {
            mins.add(0, triangle.get(i).get(0));
            if (mins.size() > 1) {
                mins.set(0, mins.get(0) + mins.get(1));
            }
            
            for (int j = 1; j < mins.size() - 1; j++) {
                int current = Math.min(mins.get(j), mins.get(j + 1));
                current += triangle.get(i).get(j);
                mins.set(j, current);
            }
            
            int last = mins.size() - 1;
            if (last < 1) continue;
            mins.set(last, mins.get(last) + triangle.get(i).get(triangle.get(i).size() - 1));
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int k : mins) {
            min = k < min ? k : min;
        }
        
        return min;
    }
}
