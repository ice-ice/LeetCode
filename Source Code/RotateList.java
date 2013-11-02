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
    public ListNode rotateRight(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int len = 0;
        
        if (head == null) return head;
        
        ListNode node = head;
        ListNode prev = head;
        
        while (node != null) {
            prev = node;
            node = node.next;
            len++;
        }
        
        n = n % len;
        
        if (n == 0) return head;
        
        int current = 1;
        
        prev.next = head;
        
        node = head;
        
        while (current < len - n) {
            node = node.next;
            current++;
        }
        
        prev = node.next;
        node.next = null;
        
        return prev;
    }
}
