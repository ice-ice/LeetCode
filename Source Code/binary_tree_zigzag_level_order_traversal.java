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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        zigzag(root, 0, lists);
        
        return lists;
    }
    
    public void zigzag(TreeNode root, int level, ArrayList<ArrayList<Integer>> lists) {
        if (root == null) return;
        
        while (lists.size() < level + 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            lists.add(list);
        }
        
        if (level % 2 == 0) {
            lists.get(level).add(root.val);
        } else {
            lists.get(level).add(0, root.val);
        }
        
        zigzag(root.left, level + 1, lists);
        zigzag(root.right, level + 1, lists);
    }
}
