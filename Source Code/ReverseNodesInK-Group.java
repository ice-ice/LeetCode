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
    public ListNode reverseKGroup(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (k <= 1) return head;
        
        ListNode last = null, prev = null, first = null, current = head, next = null, new_head = null;
        
        if (current == null || current.next == null) return head;
        
        next = current.next;
        
        int total = 0;
        
        while (current != null) {
            total++;
            current = current.next;
        }
        
        if (total < k) return head;
        
        current = head;
        
        while (total >= k && current != null) {
            int count = 0;
            
            first = current;
            while (count < k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            
            if (new_head == null) {
                new_head = prev;
            } else {
                last.next = prev;
            }
            
            first.next = current;
            last = first;
            
            total -= k;
        }
        
        return new_head;
    }
}
