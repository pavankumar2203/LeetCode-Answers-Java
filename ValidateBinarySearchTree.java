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
 * T(n) = 2T(n/2)+O(log(n))
 * O(n) O(log(n))
 */
 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null) {
            TreeNode leftMost = root.right;
            while(leftMost.left != null) leftMost = leftMost.left;
            return root.val < leftMost.val && root.val < root.right.val && isValidBST(root.right);
        }
        if(root.right == null) {
            TreeNode rightMost = root.left;
            while(rightMost.right != null) rightMost = rightMost.right;
            return root.val > root.left.val && root.val > rightMost.val && isValidBST(root.left);
        }
        TreeNode leftMost = root.right;
        while(leftMost.left != null) leftMost = leftMost.left;
        TreeNode rightMost = root.left;
        while(rightMost.right != null) rightMost = rightMost.right;
        
        return root.val > root.left.val && root.val > rightMost.val && root.val < root.right.val
            && root.val < leftMost.val && isValidBST(root.left) && isValidBST(root.right);
    }
}
