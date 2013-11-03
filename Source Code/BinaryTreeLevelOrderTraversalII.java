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
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        results.clear();
        calOrder(root, 0);
        
        return results;
    }
    
    public void calOrder(TreeNode root, int level) {
        if (root == null) return;
        
        while (results.size() < level + 1) {
            ArrayList<Integer> new_list = new ArrayList<Integer>();
            results.add(0, new_list);
        }
        
        results.get(results.size() - 1 - level).add(root.val);
        
        calOrder(root.left, level + 1);
        calOrder(root.right, level + 1);
    }
}
