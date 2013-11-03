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
    static int max = 0;
    public int maxDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        max = 0;
        calDepth(root, 1);
        
        return max;
    }
    
    public void calDepth(TreeNode root, int level) {
        if (root == null) return;
        
        max = level > max ? level : max;
        
        calDepth(root.left, level + 1);
        calDepth(root.right, level + 1);
    }
}
