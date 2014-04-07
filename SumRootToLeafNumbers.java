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
 * T(n)=2T(n/2)+O(1)
 * O(n) O(log(n))
 */

public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return changeValToSum(root, 0); //destrctive. root will be changed
    }
    public static int changeValToSum(TreeNode node, int parentSum) {
        int sum = 0;
        node.val += parentSum * 10;
        if(node.left != null) {
            sum += changeValToSum(node.left, node.val);
        }
        if(node.right != null) {
            sum += changeValToSum(node.right, node.val);
        }
        if(node.left == null && node.right == null) {
            sum = node.val;
        }
        return sum;
    }
}
