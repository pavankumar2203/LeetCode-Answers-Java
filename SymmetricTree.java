/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/**
 * swap root.right and compare root.left with root.right
 * 
 * O(log(n)) O(log(n))
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else if(root.left == null && root.right == null) return true;
        else if(root.left != null && root.right != null) {
            swap(root.right);
            return isSameTree(root.left, root.right);
        }
        else {
            return false;
        }
    }
    private void swap(TreeNode root) {
        if(root == null) return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        swap(root.left);
        swap(root.right);
    }
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        else if(t1 != null && t2 != null) {
            if(t1.val != t2.val) return false;
            else return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }
        else {
            return false;
        }
    }
}
