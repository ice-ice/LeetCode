/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ListNode slower = head;
        ListNode runner = head;
        
        if (head == null || head.next == null) return false;
        
        while (runner != null && runner.next != null) {
            slower = slower.next;
            runner = runner.next.next;
            
            if (slower == runner) return true;
        }
        
        return false;
    }
}
