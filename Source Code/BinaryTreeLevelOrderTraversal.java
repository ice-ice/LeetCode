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
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        results.clear();
        
        if (root == null) return results;
        
        calLevelOrder(root, 0);
        
        return results;
    }
    
    public void calLevelOrder(TreeNode root, int level) {
        if (root == null) return;
        
        while (results.size() < level + 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            results.add(list);
        }
        
        results.get(level).add(root.val);
        
        calLevelOrder(root.left, level + 1);
        calLevelOrder(root.right, level + 1);
    }
}
