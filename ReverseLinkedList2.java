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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(1 << 31);
        dummy.next = head;
        ListNode node = dummy;
        for(int i = 0; i < m - 1; i++) {
            node = node.next;
        }
        ListNode before = node;
        node = node.next;
        ListNode start = node; //start of list to be reversed
        for(int i = 0; i < n - m; i++) {
            node = node.next;
        }
        ListNode end = node; //end of list to be reversed
        ListNode after = end.next;
        end.next = null;
        ListNode reversedHead = reverse(start);
        before.next = reversedHead;
        while(reversedHead.next != null) {
            reversedHead = reversedHead.next;
        }
        reversedHead.next = after;
        return dummy.next;
    }
    private static ListNode reverse(ListNode head) {
        ListNode dm = new ListNode(1 << 31);
        while(head != null) {
            ListNode origDmNext = dm.next;
            dm.next = head;
            ListNode origHeadNext = head.next;
            head.next = origDmNext;
            head = origHeadNext;
        }
        return dm.next;
    }
}
