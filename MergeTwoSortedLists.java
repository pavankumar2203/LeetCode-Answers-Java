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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(1 << 31);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
            else {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
        }
        while(l1 != null) {
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
