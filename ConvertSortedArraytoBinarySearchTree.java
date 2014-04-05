/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) return null;
        int mid = num.length / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, num.length));
        
        return root;
    }
}
