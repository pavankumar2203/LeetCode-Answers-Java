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

/**
 * O(n) O(1)
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(1 << 31);
        dummy.next = head;
        ListNode node = dummy;
        while(node.next != null && node.next.next != null) {
            ListNode end = node.next.next.next;
            ListNode t = node.next;
            node.next = t.next;
            node.next.next = t;
            node.next.next.next = end;
            node = node.next.next;
        }
        return dummy.next;
    }
}
