import java.util.Stack;

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

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> retval = new ArrayList<Integer>();
        
        if(root == null) return retval;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(stack.size() != 0) {
            TreeNode node = stack.pop();
            retval.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        
        return retval;
    }
}
