public class Solution {
    public int longestValidParentheses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int max = 0, last = -1;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    max = Math.max(max, stack.isEmpty() ? i - last : i - stack.peek());
                }
            }
        }
        
        return max;
    }
}
