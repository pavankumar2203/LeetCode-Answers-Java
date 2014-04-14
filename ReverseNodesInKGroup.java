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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        ListNode dummy = new ListNode(1 << 31);
        ListNode node = dummy;
        while(head != null) {
            //get the next list of length k
            ListNode start = head;
            for(int i = 0; i < k - 1; i++) {
                if(head.next != null) {
                    head = head.next;
                } else {
                    //reached end
                    node.next = start;
                    return dummy.next;
                }
            }
            ListNode origHeadNext = head.next;
            head.next = null;
            ListNode reversedStart = reverseList(start);
            node.next = reversedStart;
            while(node.next != null) {
                node = node.next;
            }
            head = origHeadNext;
        }
        return dummy.next;
    }
    
    /**
     * reverse a linked list from head to the end
     * @param head head of linked list
     * @return reversed linked list
     */
    private static ListNode reverseList(ListNode head) {
        if(head == null) return null;
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
