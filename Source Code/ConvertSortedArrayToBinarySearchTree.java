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
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = num.length;
        
        TreeNode result = construct(num, 0, n - 1);
        
        return result;
    }
    
    public TreeNode construct(int[] num, int start, int end) {
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        
        TreeNode left = construct(num, start, mid - 1);
        TreeNode current = new TreeNode(num[mid]);
        
        current.left = left;
        
        current.right = construct(num, mid + 1, end);
        
        return current;
    }
}
