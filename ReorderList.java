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
    public void reorderList(ListNode head) {
        /**
         * scan once get len
         * reverse 2nd half
         * merge two halves
         * 
         * O(n) O(1)
         */
         if(head == null) return;
         int len = getLen(head);
         if(len <= 2) return;
         ListNode a = head;
         ListNode b = getSecondHalf(head, len);
         ListNode middle = new ListNode(1 << 31);
         if(len % 2 != 0) {
             middle = b;
             b = b.next;
             middle.next = null;
         }
         b = reverse(b);
         ListNode r = merge(a, b);
         if(len % 2 != 0) {
             if(r == null) r = middle;
             else {
                while(r.next != null) r = r.next;
                r.next = middle;
             }
         }
    }
    private static int getLen(ListNode head) {
        int i = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            i++;
        }
        return i;
    }
    private static ListNode getSecondHalf(ListNode head, int len) {
        if(head == null || len <= 1) return head;
        ListNode node = head;
        for(int i = 0; i < len / 2; i++) {
            node = node.next;
        }
        return node;
    }
    private static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(1 << 31);
        //dummy.next = head;
        ListNode node = head;
        while(node != null) {
            ListNode old = dummy.next;
            dummy.next = node;
            ListNode oldNext = node.next;
            node.next = old;
            node = oldNext;
        }
        return dummy.next;
    }
    private static ListNode merge(ListNode a, ListNode b) {
        //a.len == b.len
        ListNode dm = new ListNode(1 << 31);
        ListNode node = dm;
        while(b != null) {
            node.next = a;
            a = a.next;
            node.next.next = b;
            node = b;
            b = b.next;
        }
        return dm.next;
    }
}
