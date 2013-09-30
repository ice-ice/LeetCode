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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        
        if (root.left != null) {
            left = minDepth(root.left);
            if (left != Integer.MAX_VALUE) {
                left++;
            }
        }
        
        if (root.right != null) {
            right = minDepth(root.right);
            if (right != Integer.MAX_VALUE) {
                right++;
            }
        }
        
        return left < right ? left : right;
    }
}
