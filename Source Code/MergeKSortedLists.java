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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode node = null, head = null;
        while (!lists.isEmpty()) {
            int min = -1, val = Integer.MAX_VALUE;
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) == null) {
                    lists.remove(i);
                    min = -1;
                    break;
                }
                if (lists.get(i).val < val) {
                    val = lists.get(i).val;
                    min = i;
                }
            }
            if (min == -1) {
                continue;
            }
            if (node == null) {
                node = new ListNode(val);
                head = node;
            } else {
                ListNode next = new ListNode(val);
                node.next = next;
                node = next;
            }
            lists.set(min, lists.get(min).next);
        }
        return head;
    }
}
