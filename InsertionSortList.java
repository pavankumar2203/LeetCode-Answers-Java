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
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = null;
            insert(dummy, cur);
            cur = temp;
        }
        return dummy.next;
    }
    private void insert(ListNode dummy, ListNode node) {
        if(dummy.next==null) {
            dummy.next = node;
            return;
        }
        ListNode cur = dummy.next;
        if(node.val <= cur.val) {
            dummy.next = node;
            node.next = cur;
            return;
        }
        while(cur.next!=null && cur.next.val < node.val) {
            cur = cur.next;
        }
        ListNode temp = cur.next;
        cur.next = node;
        node.next = temp;
    }
}
