public class Solution {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int len = s.length();
        if (len <= 1) return false;
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (c == ')' && last != '(') return false;
                if (c == ']' && last != '[') return false;
                if (c == '}' && last != '{') return false;
            } else {
                return false;
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
}
