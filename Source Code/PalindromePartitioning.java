public class Solution {
    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    
    public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        results.clear();
        calPalin(s, new ArrayList<String>());
        
        return results;
    }
    
    public void calPalin(String s, ArrayList<String> list) {
        if (s.length() <= 1) {
            ArrayList<String> result = new ArrayList<String>();
            result.addAll(list);
            if (s.length() == 1) {
                result.add(s);
            }
            results.add(result);
            return;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            if (isPalin(s.substring(0, i))) {
                list.add(s.substring(0, i));
                calPalin(s.substring(i), list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    }
}
