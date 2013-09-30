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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (root == null) return;
        
        makeList(root, null);
    }
    
    public void makeList(TreeNode root, TreeNode previous) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        
        makeList(left, root);

        if (left != null) {
            TreeNode rightMost = left;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            makeList(right, rightMost);
        } else {
            makeList(right, root);
        }
        
        if (previous != null) {
            previous.right = root; 
            previous.left = null;
        }
    }
}
