/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<ArrayList<TreeLinkNode>> lists = new ArrayList<ArrayList<TreeLinkNode>>();
    
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        lists.clear();
        traverse(root, 0);
        
        for (int level = 0; level < lists.size(); level++) {
            ArrayList<TreeLinkNode> list = lists.get(level);
            
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
    }
    
    public void traverse(TreeLinkNode root, int level) {
        if (root == null) return;
        
        if (lists.size() < level + 1) {
            ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
            lists.add(list);
        }
        
        lists.get(level).add(root);
        
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
