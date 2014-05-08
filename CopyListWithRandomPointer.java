/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode curr = head;
        RandomListNode clonedNode;
        while(curr != null) {
            clonedNode = new RandomListNode(curr.label);
            RandomListNode origNext = curr.next;
            curr.next = clonedNode;
            clonedNode.next = origNext;
            curr = origNext;
        }
        curr = head;
        while(curr!=null && curr.next!=null) {
            if(curr.random!=null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        RandomListNode t1 = new RandomListNode(-1);
        RandomListNode t2 = new RandomListNode(-1);
        t1.next = head;
        t2.next = head.next;
        RandomListNode c1 = t1.next;
        RandomListNode c2 = t2.next;
        while(c1.next!=null && c2.next!=null) {
            c1.next = c1.next.next;
            c1 = c1.next;
            c2.next = c2.next.next;
            c2 = c2.next;
        }
        c1.next = null;
        return t2.next;
    }
}
