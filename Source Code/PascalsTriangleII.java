public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int[] row = new int[rowIndex + 1];
        
        for (int i = 0; i < rowIndex + 1; i++) {
            row[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                row[j] = row[j] + row[j - 1];
            }
            row[0] = 1;
        }
        
        for (int i = 0; i <= rowIndex; i++) {
            result.add(row[i]);
        }
        
        return result;
    }
}
