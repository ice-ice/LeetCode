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
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        boolean odd = false;
        ListNode prev = head, slower = head, runner = head;
        
        if (head == null || head.next == null || head.next.next == null) return;
        
        while (runner != null && runner.next != null) {
            prev = slower;
            slower = slower.next;
            runner = runner.next.next;
        }
        
        if (runner != null) {
            odd = true;
            prev = slower;
            slower = slower.next;
        }
        
        ListNode cc_prev = prev, cc = slower, cc_next = slower.next;
        
        while (cc_next != null) {
            cc.next = cc_prev;
            cc_prev = cc;
            cc = cc_next;
            cc_next = cc.next;
        }
        
        cc.next = cc_prev;
        prev.next = cc;
        slower.next = null;
        
        ListNode c_left = head, c_right = cc, n_left = head.next, n_right = cc.next;
        
        while (true) {
            c_left.next = c_right;
            c_right.next = n_left;
            if (n_right == null) break;
            c_left = n_left;
            c_right = n_right;
            n_left = n_left.next;
            n_right = n_right.next;
        }
        
        if (odd) {
            n_left.next = null;
        } else {
            c_right.next = null;
        }
    }
}
