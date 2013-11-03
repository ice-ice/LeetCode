/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (head == null || head.next == null) return head;
        
        ListNode left = head, right = head.next, next = head.next.next, newHead = head.next;
    
        while (right != null) {
            right.next = left;
            if (next != null && next.next != null) left.next = next.next;
            else left.next = next;
            
            left = next;
            if (left == null || left.next == null) return newHead;
            
            right = left.next;
            next = right.next;
        }
        
        return newHead;
    }
}
