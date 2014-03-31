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
    public boolean hasCycle(ListNode head) {
        /*
            two nodes, one move forward 1 position at a time,
            the other 2 positions at a time
            if they met then there's a circle
            
            O(n) O(1)
        */
        
        if(head == null) return false;
        
        ListNode n1 = head;
        ListNode n2 = head.next;
        while(n1 != null && n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if(n1 == n2) {
                return true;
            }
        }
        return false;
    }
}
