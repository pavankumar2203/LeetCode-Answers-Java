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
 * O(n) O(n)
 */

import java.util.LinkedList;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            depth++;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                if(node.left == null && node.right == null) return depth;
            }
        }
        return depth;
    }
}
