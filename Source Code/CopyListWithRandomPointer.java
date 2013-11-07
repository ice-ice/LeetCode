/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        map.clear();
        
        if (head == null) return null;
        RandomListNode new_head = null, new_node = null, prev_node = null, node = head;
        
        while (node != null) {
            prev_node = new_node;
            new_node = new RandomListNode(node.label);
            map.put(node, new_node);
            if (new_head == null) {
                new_head = new_node;
            } else {
                prev_node.next = new_node;
            }
            node = node.next;
        }
        
        new_node = new_head;
        node = head;
        while (new_node != null) {
            new_node.random = map.get(node.random);
            new_node = new_node.next;
            node = node.next;
        }
        
        return new_head;
    }
}
