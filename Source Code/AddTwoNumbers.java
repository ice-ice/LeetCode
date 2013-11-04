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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int len1 = len(l1), len2 = len(l2);
        ListNode head = len1 > len2 ? l1 : l2;
        ListNode current = head, prev = head;
        
        int sum = 0, carry = 0;
        
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            current.val = sum;
            prev = current;
            current = current.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            while (l1 != null) {
                sum = l1.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                current.val = sum;
                prev = current;
                current = current.next;
                l1 = l1.next;
            }
        } else if (l2 != null) {
            while (l2 != null) {
                sum = l2.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                current.val = sum;
                prev = current;
                current = current.next;
                l2 = l2.next;
            }
        }
        
        if (carry > 0) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        
        return head;
    }
    /*
    public void add(ListNode l1, ListNode l2, ListNode result, int carry, int current, int len) {
        if (current == len) {
            if (carry > 0) {
                result.val = 1;
                ListNode node = new ListNode();
                result.next = node;
            }
            return;
        }
        
        int sum = l1.val + l2.val + carry;
        
        result.val = sum % 10;
        
        ListNode node = new ListNode();
        result.next = node;
        
        add(l1.next, l2.next, node, sum / 10, current + 1, len);
    }
    
    public ListNode pad(ListNode l, int len) {
        while (len > 0) {
            ListNode node = new ListNode(0);
            node.next = l;
            l = node;
            len--;
        }
        return l;
    }*/
    
    public int len(ListNode l) {
        int count = 0;
        while (l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
}
