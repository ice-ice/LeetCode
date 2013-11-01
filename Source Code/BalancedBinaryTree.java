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
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (compare(root) != -1) return true;
        else return false;
    }
    
    public int compare(TreeNode root) {
        if (root == null) return 0;
        
        int hl = compare(root.left);
        int hr = compare(root.right);
        
        if (hl == -1 || hr == -1) return -1;
        
        if (Math.abs(hl - hr) > 1) return -1;
        else return Math.max(hl, hr) + 1;
    }
}
