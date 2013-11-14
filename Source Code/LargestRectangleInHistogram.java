public class Solution {
    public int largestRectangleArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Stack<Integer> s = new Stack<Integer>();
        int len = height.length, max = Integer.MIN_VALUE;
        
        if (len == 0) return 0;
        
        for (int i = 0; i < len; i++) {
            if (s.isEmpty() || height[i] > height[s.peek()]) {
                s.push(i);
            } else {
                int tmp = s.pop();
                max = Math.max(max, height[tmp] * (s.isEmpty() ? i : (i - 1 - s.peek())));
                --i;
            }
        }
        
        while (!s.isEmpty()) {
            int tmp = s.pop();
            max = Math.max(max, height[tmp] * (s.isEmpty() ? len : (len - s.peek() - 1)));
        }
        
        return max;
    }
}
