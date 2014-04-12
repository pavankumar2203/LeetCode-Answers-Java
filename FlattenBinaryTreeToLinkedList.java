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
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left == null) return;
        TreeNode l = root.left;
        while(l.right != null) l = l.right;
        l.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
