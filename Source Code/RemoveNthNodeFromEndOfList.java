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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int count = 1;
        ListNode current = head;
        ListNode previous = head;
        
        while (count < n && current.next != null) {
            current = current.next;
            count++;
        }
        
        ListNode removed = head;
        
        if (current.next == null) return head.next;
        
        while (current.next != null) {
            current = current.next;
            previous = removed;
            removed = removed.next;
        }
        
        previous.next = removed.next;
        
        return head;
    }
}
