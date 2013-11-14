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
    static TreeNode n1, n2, prev;
    public void recoverTree(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        n1 = null;
        n2 = null;
        prev = null;
        
        recover(root);
        
        if (n1 != null && n2 != null) {
            swapVal(n1, n2);
        }
    }
    
    public void recover(TreeNode root) {
        if (root == null) return;
        
        if (root.left != null) recover(root.left);
        
        if (prev != null && root.val < prev.val) {
            n2 = root;
            if (n1 == null) {
                n1 = prev;
            }
        }
        
        prev = root;
        
        if (root.right != null) recover(root.right);
    }
    
    public void swapVal(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
