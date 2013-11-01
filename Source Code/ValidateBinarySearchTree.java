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
    static int previous, current;
    
    public boolean isValidBST(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        previous = Integer.MIN_VALUE;
        current = Integer.MIN_VALUE;
        
        return valid(root);
    }
    
    public boolean valid(TreeNode root) {
        if (root == null) return true;
        
        if (!valid(root.left)) return false;
        
        previous = current;
        current = root.val;
        
        if (current <= previous) return false;
        
        return valid(root.right);
    }
}
