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
 * use a stack
 * push root
 * while stack not empty:
 *  pop a node
 *  push right
 *  if not visited yet: push node
 *  else: print node.val
 *  push left
 * 
 * O(n) O(n)
 */
 
import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> retval = new ArrayList<Integer>();
        if(root == null) return retval;
        Stack<TreeNode2> stack = new Stack<TreeNode2>();
        stack.push(new TreeNode2(root));
        
        while(!stack.isEmpty()) {
            TreeNode2 node2 = stack.pop();
            
            if(node2.visited) {
                retval.add(node2.node.val);
            }
            else {
                node2.visited = true;
                if(node2.node.right != null) {
                    stack.push(new TreeNode2(node2.node.right));
                }
                stack.push(node2);
                if(node2.node.left != null) {
                    stack.push(new TreeNode2(node2.node.left));
                }
            }
        }
        return retval;
    }
    
    private static class TreeNode2 {
        TreeNode node;
        boolean visited;
        TreeNode2(TreeNode n) {
            node = n;
            visited = false;
        }
    }
}
