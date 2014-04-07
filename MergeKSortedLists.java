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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(lists.size() > 0) {
            for(int i = 0; i < lists.size(); i++) {
                if(lists.get(i) == null) {
                    lists.remove(i);
                    i--;
                }
            }
            if(lists.size() > 0) {
                int minIndex = 0;
                int minVal = lists.get(0).val;
                for(int i = 1; i < lists.size(); i++) {
                    if(lists.get(i) != null && lists.get(i).val < minVal) {
                        minVal = lists.get(i).val;
                        minIndex = i;
                    }
                }
                node.next = lists.get(minIndex);
                lists.set(minIndex, lists.get(minIndex).next);
                node = node.next;
            }
        }
        return dummy.next;
    }
}
