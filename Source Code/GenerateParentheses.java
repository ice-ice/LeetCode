public class Solution {
    ArrayList<String> results = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        results.clear();
        char[] str = new char[2 * n];
        
        calParentthesis(n, n, 0, str);
        return results;
    }
    
    public void calParentthesis(int left, int right, int k, char[] str) {
        if (left == 0) {
            for (int i = k; i < str.length; i++) {
                str[i] = ')';
            }
            String s = new String(str);
            results.add(s);
            return;
        }
        
        str[k] = '(';
        calParentthesis(left - 1, right, k + 1, str);
        
        if (right > left) {
            str[k] = ')';
            calParentthesis(left, right - 1, k + 1, str);
        }
    }
}
