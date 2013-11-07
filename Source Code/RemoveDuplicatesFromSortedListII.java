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
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (head == null || head.next == null) return head;
        
        boolean removeCurrent = false, removeHead = false;
        
        while (head.next != null) {
            if (head.val == head.next.val) {
                removeHead = true;
                head.next = head.next.next;
            } else if (removeHead) {
                removeHead = false;
                head = head.next;
            } else {
                break;
            }
        }
        
        if (removeHead) {
            head = head.next;
        }
        
        if (head == null) return null;
        
        ListNode previous = head, current = head, next = head.next;
        
        while (next != null) {
            if (current.val == next.val) {
                removeCurrent = true;
                next = next.next;
                current.next = next;
            } else if (removeCurrent) {
                removeCurrent = false;
                previous.next = next;
                current = next;
                next = next.next;
            } else {
                previous = current;
                current = next;
                next = next.next;
            }
        }
        
        if (removeCurrent) {
            previous.next = next;
        }
        
        return head;
    }
}
