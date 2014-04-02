/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> retval = new ArrayList<ArrayList<Integer>>();
        if(root == null) return retval;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        boolean isFromLeftToRight = true;
        while(!list.isEmpty()) {
            int size = list.size();
            ArrayList<Integer> levelVals = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                levelVals.add(node.val);
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            if(!isFromLeftToRight) {
                for(int j = 0; j < levelVals.size() / 2; j++) {
                    int t = levelVals.get(j);
                    levelVals.set(j,levelVals.get(levelVals.size() - 1 - j));
                    levelVals.set(levelVals.size() - 1 - j, t);
                }
            }
            isFromLeftToRight = !isFromLeftToRight;
            retval.add(levelVals);
        }
        
        return retval;
    }
}
