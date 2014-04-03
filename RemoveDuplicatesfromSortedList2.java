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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        boolean isDuplicate = false;
        ListNode node = dummy;
        while(node.next != null) {
            if(node.next.next == null) {
                break;
            }
            if(node.next.val != node.next.next.val) {
                if(isDuplicate) {
                    node.next = node.next.next;
                }
                else {
                    node = node.next;
                }
                isDuplicate = false;
            }
            else {
                isDuplicate = true;
                node.next.next = node.next.next.next;
            }
        }
        if(isDuplicate) {
            node.next = null;
        }
        return dummy.next;
    }
}
