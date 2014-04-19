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
    public int maxPathSum(TreeNode root) {
        IntHolder max = new IntHolder(1 << 31);
        maxPathSum0(root, max);
        return max.value;
    }
    private static int maxPathSum0(TreeNode root, IntHolder max) {
        if(root == null) {
            return 0;
        }
        int l = maxPathSum0(root.left, max);
        int r = maxPathSum0(root.right, max);
        int sum = root.val;
        if(l > 0) {
            sum += l;
        }
        if(r > 0) {
            sum += r;
        }
        max.value = Math.max(max.value, sum);
        if(Math.max(l, r) > 0) {
            return root.val + Math.max(l, r);
        } else {
            return root.val;
        }
    }
    static class IntHolder {
        int value;
        IntHolder(int v) {
            value = v;
        }
    }
}
