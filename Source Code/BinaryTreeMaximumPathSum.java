/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static int MAX = Integer.MIN_VALUE, level = 0;
    public int maxPathSum(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (root == null) return 0;
        
        int left, right, max, cur = root.val;
        
        if (level == 0) MAX = Integer.MIN_VALUE;
        
        ++level;
        left = maxPathSum(root.left);
        right = maxPathSum(root.right);
        --level;
        
        MAX = Math.max(left + cur + right, MAX);
        max = Math.max(cur, cur + left);
        max = Math.max(max, cur + right);
        MAX = Math.max(MAX, max);
        
        return level == 0 ? MAX : max;
    }
}
