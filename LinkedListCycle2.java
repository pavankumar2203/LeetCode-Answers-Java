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
    public ListNode detectCycle(ListNode head) {
        /*
            A O(n) O(1) way which is destructive
            
            use the turtle rabit method to detect the circle
            along the way set all vals to 1
            once realize in the circle change all the vals in circle to 0
            start from head again and find the first 0
        */
        
        if(head == null) return null;
        ListNode n1 = head;
        ListNode n2 = head.next;
        
        while(n1 != null && n2 != null && n2.next != null) {
            n1.val = 1;
            n2.val = 1;
            n1 = n1.next;
            n2 = n2.next.next;
            
            if(n1 == n2) break;
        }
        if(n1 == null || n2 == null || n2.next == null) return null;
        n2 = n2.next;
        n1.val = 0;
        while(n2 != n1) {
            n2.val = 0;
            n2 = n2.next;
        }
        
        n1 = head;
        while(n1.val != 0) {
            n1 = n1.next;
        }
        return n1;
    }
}
