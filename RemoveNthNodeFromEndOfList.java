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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(1 << 31);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = dummy;
        for(int i = 0; i < n; i++) {
            if(a != null) a = a.next;
            else return head;
        }
        while(a.next != null) {
            a = a.next;
            b = b.next;
        }
        b.next = b.next.next;
        return dummy.next;
    }
}//O(n) O(1)
