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
    static ListNode h, t;
    public ListNode partition(ListNode head, int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        h = new ListNode(-1);
        t = new ListNode(-2);
        
        ListNode lc = h, rc = t, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lc.next = cur;
                lc = lc.next;
            } else {
                rc.next = cur;
                rc = rc.next;
            }
            cur = cur.next;
        }
        
        lc.next = t.next;
        rc.next = null;
        
        return h.next;
    }
}
