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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        getAllSums(root, sum, list, results);
        
        return results;
    }
    
    public void getAllSums(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> results) {
        if (root == null) return;
        
        if (sum == root.val && root.left == null && root.right == null) {
            ArrayList<Integer> _list = new ArrayList<Integer>();
            for (int d : list) {
                _list.add(d);
            }
            _list.add(root.val);
            results.add(_list);
            return;
        }
        
        if (root.left != null) {
            list.add(root.val);
            getAllSums(root.left, sum - root.val, list, results);
            list.subList(list.size() - 1, list.size()).clear();
        }
        
        if (root.right != null) {
            list.add(root.val);
            getAllSums(root.right, sum - root.val, list, results);
            list.subList(list.size() - 1, list.size()).clear();
        }
    }
}
