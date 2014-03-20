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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
            O(n) algo:
            
            carrier c = 0;
            next digit d = (d1+d2+c)%10
            c = (d1+d2+c)/10
            if one list is done:
                continue with the other list
            if both lists are done:
                check c
        */
        
        ListNode n = new ListNode(-1);
        ListNode h = n;//temp head
        int c = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + c;
            n.next = new ListNode(sum % 10);
            c = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            n = n.next;
        }
        while(l1 != null) {
            int sum = l1.val + c;
            n.next = new ListNode(sum % 10);
            c = sum /10;
            l1 = l1.next;
            n = n.next;
        }
        while(l2 != null) {
            int sum = l2.val + c;
            n.next = new ListNode(sum % 10);
            c = sum /10;
            l2 = l2.next;
            n = n.next;
        }
        if(c != 0) {
            n.next = new ListNode(c);
        }
        
        return h.next;
    }
}
