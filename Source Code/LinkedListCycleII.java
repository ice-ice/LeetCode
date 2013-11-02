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
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ListNode slower = head, runner = head;
        
        if (head == null || head.next == null) return null;
        
        while (runner != null && runner.next != null) {
            slower = slower.next;
            runner = runner.next.next;
            
            if (slower == runner) {
                slower = head;
                
                while (slower != runner) {
                    slower = slower.next;
                    runner = runner.next;
                }
                
                return runner;
            }
        }
        
        return null;
    }
}
