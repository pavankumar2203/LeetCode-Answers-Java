/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced2(root) >= 0;
    }
    private static int isBalanced2(TreeNode root) {
        if(root == null) return 0;
        int left = isBalanced2(root.left);
        int right = isBalanced2(root.right);
        if(left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
