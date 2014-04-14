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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(1 << 31);
        ListNode big = new ListNode(1 << 31);
        ListNode currSmall = small;
        ListNode currBig = big;
        while(head != null) {
            ListNode origHeadNext = head.next;
            if(head.val < x) {
                currSmall.next = head;
                head.next = null;
                currSmall = currSmall.next;
            } else {
                currBig.next = head;
                head.next = null;
                currBig = currBig.next;
            }
            head = origHeadNext;
        }
        currSmall.next = big.next;
        return small.next;
    }
}
