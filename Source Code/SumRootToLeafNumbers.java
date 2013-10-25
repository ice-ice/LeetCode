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
    static int sum = 0;
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        sum = 0;
        calSum(root);
        
        return sum;
    }
    
    public void calSum(TreeNode root) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        
        if (root.left != null) {
            root.left.val += root.val * 10;
            calSum(root.left);
        }
        
        if (root.right != null) {
            root.right.val += root.val * 10;
            calSum(root.right);
        }
    }
}
