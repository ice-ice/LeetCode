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
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        result.clear();
        inorder(root);
        return result;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
