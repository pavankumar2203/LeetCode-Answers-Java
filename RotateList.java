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
 * scan list once and get length l
 * k = k%l
 * scan again till l-k'th node end
 * break end and end.next
 * scan end.next till end of list
 * connect the last elem with head
 * O(n) O(1)
 */
 
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        int l = 0;
        ListNode node = head;
        while(node != null) {
            l++;
            node = node.next;
        }
        int k = n % l;
        if(k == 0) return head;
        node = head;
        for(int i = 0; i < l - k - 1; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        node = newHead;
        while(node.next != null) {
            node = node.next;
        }
        node.next = head;
        return newHead;
    }
}
