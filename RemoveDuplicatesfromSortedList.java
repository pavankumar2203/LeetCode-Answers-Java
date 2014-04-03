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
        if(head == null) return null;
        
        ListNode node = head;
        while(node != null) {
            if(node.next != null) {
                if(node.next.val != node.val) {
                    node = node.next;
                }
                else {
                    node.next = node.next.next;
                }
            }
            else {
                break;
            }
        }
        
        return head;
    }
}
