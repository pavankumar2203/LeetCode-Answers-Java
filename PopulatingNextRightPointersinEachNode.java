/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null||root.left==null)return;
        TreeLinkNode l = root.left;
        TreeLinkNode r = root.right;
        l.next=r;
        while(l.right!=null){
            l=l.right;
            r=r.left;
            l.next=r;
        }
        connect(root.left);
        connect(root.right);
    }
}
