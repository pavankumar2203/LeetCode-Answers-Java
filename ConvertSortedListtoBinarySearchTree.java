/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        TreeNode root;
        if(head.next == null) {
            root = new TreeNode(head.val);
            return root;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            if(fast!=null)
                slow = slow.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(middle.next);
        root = new TreeNode(middle.val);
        root.left = left;
        root.right = right;
        return root;
    }
}
