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
    public ListNode sortList(ListNode head) {
        /**
         * top down
         * 
         */
         int len = 0;
         ListNode curr = head;
         while(curr != null) {
             curr = curr.next;
             len++;
         }
         if(len < 2) return head;
         curr = head;
         for(int i = 0; i < len / 2 - 1; i++) {
             curr = curr.next;
         }
         ListNode l = head;
         ListNode r = curr.next;
         curr.next = null;
         l = sortList(l);
         r = sortList(r);
         
         //merge
         ListNode dummy = new ListNode(1 << 31);
         curr = dummy;
         while(l != null && r != null) {
             if(l.val < r.val) {
                 curr.next = l;
                 l = l.next;
                 curr = curr.next;
             }
             else {
                 curr.next = r;
                 r = r.next;
                 curr = curr.next;
             }
         }
         while(l != null) {
             curr.next = l;
             l = l.next;
             curr = curr.next;
         }
         while(r != null) {
             curr.next = r;
             r = r.next;
             curr = curr.next;
         }
         return dummy.next;
    }
}
