/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    static ListNode root;
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int n = 0;
        ListNode node = head;
        
        while (node != null) {
            node = node.next;
            n++;
        }
        
        root = head;
        
        TreeNode result = construct(0, n - 1);
        
        return result;
    }
    
    public TreeNode construct(int start, int end) {
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        
        TreeNode left = construct(start, mid - 1);
        TreeNode current = new TreeNode(root.val);
        
        current.left = left;
        root = root.next;
        
        current.right = construct(mid + 1, end);
        
        return current;
    }
}
