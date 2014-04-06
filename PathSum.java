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
 * O(n) O(log(n))
 */
 
import java.util.Stack;
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        NodeSum nsr = new NodeSum(root, root.val);
        Stack<NodeSum> s = new Stack<NodeSum>();
        s.push(nsr);
        while(!s.empty()) {
            NodeSum ns = s.pop();
            if(ns.node.right != null) {
                s.push(new NodeSum(ns.node.right, ns.node.right.val + ns.sum));
            }
            if(ns.node.left != null) {
                s.push(new NodeSum(ns.node.left, ns.node.left.val + ns.sum));
            }
            if(ns.node.left == null && ns.node.right == null) {
                if(sum == ns.sum) {
                    return true;
                }
            }
        }
        return false;
    }
    private class NodeSum {
        TreeNode node;
        int sum;
        NodeSum(TreeNode tr, int n) {
            node = tr;
            sum = n;
        }
    }
}
