/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> retval = new ArrayList<ArrayList<Integer>>();
        if(root == null) return retval;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(size-- > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            retval.add(list);
        }
        for(int i = 0; i < retval.size() / 2; i++) {
            ArrayList<Integer> t = retval.get(i);
            retval.set(i, retval.get(retval.size() - 1 - i));
            retval.set(retval.size() - 1 - i, t);
        }
        
        return retval;
    }
}
