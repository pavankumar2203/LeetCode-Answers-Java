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
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        Stack<SumNode> stack = new Stack<SumNode>();
        stack.push(new SumNode(root, root.val, null));
        
        while(!stack.empty()) {
            SumNode sn = stack.pop();
            if(sn.node.right != null) {
                stack.push(new SumNode(sn.node.right, sn.sum + sn.node.right.val, sn));
            }
            if(sn.node.left != null) {
                stack.push(new SumNode(sn.node.left, sn.sum + sn.node.left.val, sn));
            }
            if(sn.node.left == null && sn.node.right == null) {
                if(sn.sum == sum) {
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    
                    while(sn != null) {
                        al.add(0, sn.node.val);
                        sn = sn.parent;
                    }
                    
                    result.add(al);
                }
                
            }
        }
        
        return result;
    }
    private class SumNode {
        TreeNode node;
        int sum;
        SumNode parent;
            
        SumNode(TreeNode node, int sum, SumNode parent) {
            this.node = node;
            this.sum = sum;
            this.parent = parent;
        }
    }
}
