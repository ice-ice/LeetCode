public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        int[] row = new int[numRows];
        
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> current_row = new ArrayList<Integer>();
            row[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                row[j] = row[j] + row[j - 1];
            }
            row[0] = 1;
            for (int j = 0; j <= i; j++) {
                current_row.add(row[j]);
            }
            results.add(current_row);
        }
        
        return results;
    }
}
